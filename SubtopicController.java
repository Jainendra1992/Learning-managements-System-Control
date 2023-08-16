package com.website.lms.controller;

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

import com.website.lms.Service.SubtopicService;
import com.website.lms.dto.SaveSuccessStatus;
import com.website.lms.entity.Subtopic;

@RestController
@RequestMapping("subtopic")
@CrossOrigin
public class SubtopicController {
	@Autowired
	private SubtopicService subtopicService;
	@PostMapping
	public ResponseEntity<SaveSuccessStatus> save(@RequestBody Subtopic subtopic)
	{
		 subtopicService.save(subtopic);
		 SaveSuccessStatus saveSuccessStatus = new SaveSuccessStatus();
		 saveSuccessStatus.setMessage("Data saved Successfully");
		 saveSuccessStatus.setStatus(true);
		 return  ResponseEntity.ok(saveSuccessStatus);
	}
	@GetMapping
	public Iterable<Subtopic> get()
	{
		return subtopicService.get();
	}
	@GetMapping("/{id}")
	public Subtopic getById(@PathVariable Integer id)
	{
		return subtopicService.getById(id);
	}
     @DeleteMapping
	public String delete()
	{
		subtopicService.delete();
		return "Data delete Successfully";
	}
     @PutMapping
     public Subtopic update(@RequestBody Subtopic subtopic)
     {
    	 return subtopicService.save(subtopic);
     }
}
