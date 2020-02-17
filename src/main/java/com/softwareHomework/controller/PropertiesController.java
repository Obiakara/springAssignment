package com.softwareHomework.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwareHomework.Impl.PropertiesImpl;
import com.softwareHomework.model.PostRequestBody;
import com.softwareHomework.model.Properties;
import com.softwareHomework.repository.IPropertiesDAO;

@RestController
@RequestMapping("/properties")
public class PropertiesController {
	
	private final Logger LOGGER = LogManager.getLogger(PropertiesController.class);

	@Autowired
	private PropertiesImpl propertiesImpl;

	@GetMapping
	public ResponseEntity<List<Properties>> getproperties(){
		
		LOGGER.info("Properties List Requested");

		List<Properties> properties = propertiesImpl.findAll();
		
		if(properties.size() > 1){
			
			LOGGER.info("Data retrieved from database cuccesfuly");

			return new ResponseEntity<List<Properties>>(properties, HttpStatus.OK);
		}

		LOGGER.info("Result not found");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> postProperties(@RequestBody PostRequestBody properties){
		
		LOGGER.info(properties.toString());
		
		JSONObject jsonObject = new JSONObject();
		String address = properties.getAddress();
		String city = properties.getCity();
		String state = properties.getState();
		String zip = properties.getZip();

		if(address.length() > 200){


			jsonObject.put("Message", "Address is more than 200 characters");

			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);
		}

		if(city.length() > 50){

			jsonObject.put("Message", "City is more than 50 characters");

			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);
		}

		if(state.length() != 2){


			jsonObject.put("Message", "State is more than less than 2 characters");

			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);
		}

		if(zip.length() > 5 || zip.length() > 10 ){

			jsonObject.put("Message", "Zip is not within range characters");
			System.out.println(jsonObject.toString());

			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);
		}


		int insert = propertiesImpl.insertIntoProperties(address, city, state, zip);

		if(insert == 1){//ensure insert query worked
			jsonObject.put("message", "added");
		}

		LOGGER.info("Item posted succesfully");
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Properties> getPropertyByID(@PathVariable String id){
		
		LOGGER.info("Property ID requested = + " + id);

		int propertyID = Integer.valueOf(id);

		try{
			
			Optional<Properties> optionalProperty = propertiesImpl.findById(propertyID);
			Properties properties = optionalProperty.get();

			if(properties.getAddress() != null){

				return new ResponseEntity<Properties>(properties, HttpStatus.OK);

			}

			return new ResponseEntity<Properties>(HttpStatus.NOT_FOUND);

		}catch(Exception ex){

			return new ResponseEntity<Properties>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePropertyByID(@PathVariable String id){

		JSONObject jsonObject = new JSONObject();
		int propertyID = Integer.valueOf(id);

		try{
			propertiesImpl.deleteById(propertyID);
		}catch(Exception ex){

			jsonObject.put("message", "Unable to delete property with the specified ID");
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);

		}

		jsonObject.put("message", "Property deleted");
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
	}

}
