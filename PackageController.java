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

import com.website.lms.dto.SaveSuccessStatus;
import com.website.lms.entity.Package;

@RestController
@RequestMapping("package") //http://localhost:9093/package
@CrossOrigin
public class PackageController {

	@Autowired
	private com.website.lms.Service.PackageService packageService;
	
	@Autowired
	private com.website.lms.Repository.PackageRepository packageRepository;
	
	//Create
	@PostMapping("/post")
	public ResponseEntity<SaveSuccessStatus> save(@RequestBody Package package1)
	{
		 System.err.println("came inside controller");
		 packageService.save(package1);
		 System.err.println("went to service");
		 SaveSuccessStatus saveSuccessStatus = new SaveSuccessStatus();
		    saveSuccessStatus.setMessage("Data Saved Successfully");
		    System.err.println("generating dto");
		    saveSuccessStatus.setStatus(true);
		    System.err.println("dto generated");
		    return ResponseEntity.ok(saveSuccessStatus);
		
		
	}
	
	//Read All Data
	@GetMapping
	public Iterable<Package> getName()
	{
		System.err.println("getting from service");
		return packageService.getByName();
	}
	
	//Read Particular Data
	@GetMapping("/{id}") //http://localhost:9093/package/id
	public Package getById(@PathVariable Integer id)
	{
		return packageService.getById(id);
	}
	
	//delete All Method
	@DeleteMapping
	public String delete()
	{
		packageService.delete();
		return "Data Deleted Successfully";
	}
	
	//Delete Particular data
	@DeleteMapping("/{id}")// http://localhost:9091/package/id
	public String deleteById(@PathVariable Integer id)
	{
		packageService.deleteById(id);
		return "Data Deleted Successfully";
	}
	
	//Update data
	@PutMapping
	public Package update(@RequestBody Package package1)
	{
		Package data = packageRepository.findById(package1.getId()).get();
		
		data.setPackageName(package1.getPackageName());
		data.setPackageFees(package1.getPackageFees());
		data.setPackageHours(package1.getPackageHours());
		data.setPackageDuration(package1.getPackageDuration());
		
		return packageService.save(data);

		
	}
	
}