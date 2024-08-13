package com.telusko.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.web.dao.AlienRepo;
import com.telusko.web.model.Alien;

@Controller
public class AlienController {

		
	@RequestMapping("/")
	public String home() {	
		return "home.jsp";
	}
	
	@Autowired
	AlienRepo alienRepo;

	@PostMapping(path = "/alien", consumes = { "application/json" })
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@GetMapping("/getAlien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
	  Optional<Alien> alien=alienRepo.findById(aid);
		return alien;
	}
	
	
}
