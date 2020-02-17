package com.softwareHomework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softwareHomework.model.Properties;


public interface IPropertiesDAO extends JpaRepository<Properties, Integer> {
	
	@Modifying // modifying is used to enhance the Query for insert, update etc
	@Transactional //transactional is used when updating a database
    @Query(value = "insert into properties (address, city, state,zip) "
    		+ "VALUES (:address,:city, :state, :zip)", nativeQuery = true)
	
   int insertIntoProperties(@Param("address") String address, @Param("city")String city,
			@Param("state")String state, @Param("zip")String zip);

}
