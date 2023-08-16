package com.website.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.lms.Service.SkillService;
import com.website.lms.dto.SaveSuccessStatus;
import com.website.lms.entity.Skill;

@RestController
@RequestMapping("skill")
@CrossOrigin
public class skillController {

	@Autowired
	private SkillService skillService;
	@PostMapping
	public ResponseEntity<SaveSuccessStatus> save(@RequestBody Skill skill)
	{
		skillService.save(skill);
		SaveSuccessStatus saveSuccessStatus = new SaveSuccessStatus();
		saveSuccessStatus.setMessage("Data saved Successfully");
		saveSuccessStatus.setStatus(true);
		return ResponseEntity.ok(saveSuccessStatus);
	}
	
	
	@GetMapping
	public Iterable<Skill> get()
	{
		return skillService.get();
	}
	@GetMapping("/{id}")
	public Skill getById(@PathVariable Integer id)
	{
	   return skillService.getById(id);
	}
	@DeleteMapping("/{id}")
	public String delete()
	{
		 skillService.delete();
		 return"Data Delete Successfully";
	}
	@PutMapping
	public Skill update(@RequestBody Skill skill)
	{
		return skillService.save(skill);
	}
}
