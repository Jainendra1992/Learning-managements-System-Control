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

import com.website.lms.Service.TopicsService;
import com.website.lms.dto.SaveSuccessStatus;
import com.website.lms.entity.Topics;

@RestController
@RequestMapping("topics")
@CrossOrigin
public class TopicsController {

	@Autowired
	private TopicsService topicsService;
	@PostMapping
	public ResponseEntity<SaveSuccessStatus> save(@RequestBody Topics topics)
	{
		topicsService.save(topics);
		SaveSuccessStatus saveSuccessStatus  = new SaveSuccessStatus();
		saveSuccessStatus.setMessage("Data saved successfully");
		saveSuccessStatus.setStatus(true);
		return ResponseEntity.ok(saveSuccessStatus);
	}
	@GetMapping
	public Iterable<Topics>get()
	{
		return topicsService.get();
	}
	@GetMapping("/{id}")
	public Topics getById(@PathVariable Integer id)
	{
		return topicsService.getById(id);
	}
	@DeleteMapping("/{id}")
	public String delete()
	{
		topicsService.delete();
		return "Data Delete successfully";
	}
	@PutMapping
	public Topics update(@RequestBody Topics topics)
	{
		return topicsService.save(topics);
	}
}
