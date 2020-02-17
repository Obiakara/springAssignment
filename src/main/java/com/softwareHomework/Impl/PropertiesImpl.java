package com.softwareHomework.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softwareHomework.model.Properties;
import com.softwareHomework.repository.IProperties;
import com.softwareHomework.repository.IPropertiesDAO;
@Service
public class PropertiesImpl implements IProperties{

	@Autowired
	IPropertiesDAO propertiesDao;

	public List<Properties> findAll() {
		// TODO Auto-generated method stub
		return propertiesDao.findAll();
	}

	public int insertIntoProperties(String address, String city, String state, String zip) {
		// TODO Auto-generated method stub
		return propertiesDao.insertIntoProperties(address, city, state, zip);
	}

	public void deleteById(int propertyID) {
		
		propertiesDao.deleteById(propertyID);
		
	}

	public Optional<Properties> findById(int propertyID) {
		// TODO Auto-generated method stub
		return propertiesDao.findById(propertyID);
	}

}
