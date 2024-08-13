package com.telusko.web.dao;

import org.springframework.data.repository.CrudRepository;

import com.telusko.web.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
