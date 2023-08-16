package com.website.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.lms.Service.AppUserService;
import com.website.lms.dto.ChangePasswordStatus;
import com.website.lms.dto.EmailVerificationStatus;
import com.website.lms.dto.LoginSuccessStatus;
import com.website.lms.dto.PasswordChange;
import com.website.lms.dto.ResetPasswordStatus;
import com.website.lms.dto.SendMailOnForgottenPasswordStatus;
import com.website.lms.dto.SignupSuccessStatus;
import com.website.lms.entity.AppUser;

import jakarta.persistence.Id;

@RestController
@RequestMapping("admin")
@CrossOrigin			//to allow any type of client
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;	//interacting with service layer
	
	@PostMapping("signup")
	public ResponseEntity<SignupSuccessStatus> save(@RequestBody AppUser appUser)
	  throws Exception
	{
		return ResponseEntity.ok(appUserService.save(appUser));
	}
	/*
	 {
	 	"firstName": "Anil",
	 	"lastName": "Kumar",
		"email" : "A@gmail.com",
		"password": "abc"
	 }
	 http://localhost:9090/admin/signup
	 */
	
		
	@PostMapping("login")
	public ResponseEntity<LoginSuccessStatus> login(@RequestBody AppUser appUser)
	{
		return ResponseEntity.ok(appUserService.login(appUser));
	}
	
	
	 
	@PostMapping("sendMailOnForgottenPassword")
	public ResponseEntity<SendMailOnForgottenPasswordStatus> 
			sendMailOnForgottenPassword(@RequestBody AppUser appUser)
					throws Exception
	{
		return ResponseEntity.ok(
				appUserService.sendMailOnForgottenPassword(appUser));
	}
	/*
 	{
		"email":"m@gmail.com",
 	}
 	http://localhost:9090/admin/sendMailOnForgottenPassword
	 */
	
	
	@PostMapping("resetPassword")
	public ResponseEntity<ResetPasswordStatus> 
	resetPassword(@RequestParam String email, 
				  @RequestParam String password, 
				  @RequestParam String confirmPassword)
	{
		return ResponseEntity.ok(
				appUserService.resetPassword(email, password, confirmPassword));
	}
	
	@PostMapping("changePassword")
	public ResponseEntity<ChangePasswordStatus> 
	changePassword(@RequestBody PasswordChange passwordChange)
	{
		return ResponseEntity.ok(
				appUserService.changePassword(passwordChange.getEmail(), 
						passwordChange.getOldPassword(), 
						passwordChange.getPassword(), 
						passwordChange.getConfirmPassword()));
	}
	
	
	/*
	INSERT INTO APP_USER(STATUS, EMAIL,FIRST_NAME, LAST_NAME, PASSWORD, TOKEN) VALUES(1, 'a@a.com', 'abc', 'xyz', '123', 'test');
	{
		"email":"a@a.com",
		"oldPassword":"123",
		"password":"456",
		"confirmPassword":"456"
	}
	*/
	
	
	
	
	
	
	
	@GetMapping("verifyMailId/{token}/{email}")
	public ResponseEntity<EmailVerificationStatus> verifyMailId(@PathVariable String token, 
					@PathVariable String email) 
	{
		return ResponseEntity.ok(appUserService.verifyMailId(token, email));
	}
	
	
	
	
	
	
	
	
	
	
}
