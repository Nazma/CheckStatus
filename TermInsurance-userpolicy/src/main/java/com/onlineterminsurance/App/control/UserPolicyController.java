package com.onlineterminsurance.App.control;

import java.util.List;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineterminsurance.App.entity.UserPolicy;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;
import com.onlineterminsurance.App.service.UserPolicyService;

@RestController
@RequestMapping("/api/v2")
public class UserPolicyController {
	@Autowired
	private UserPolicyService userService;

	@GetMapping("/getAlluserpolicies")
	public List<UserPolicy> getAllUserPolicies() {
		return userService.getAllUserPolicies();
	}

	@GetMapping("/finduserpolicy/{id}")
	public ResponseEntity<UserPolicy> getUserPolicyById(@PathVariable(value = "id") Integer userpolicyid) throws ResourceNotFoundException {
		UserPolicy user= userService.findUserPolicyById(userpolicyid);
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/saveuserpolicy")
	public UserPolicy createUserPolicy( @RequestBody UserPolicy user ) {
		return userService.saveUserPolicy(user);
	}

	@PutMapping("/updateuserpolicy/{id}")
	public ResponseEntity<UserPolicy> updateUserPolicyById(@PathVariable(value = "id") Integer userpolicyid,
			 @RequestBody UserPolicy user) throws ResourceNotFoundException {
		UserPolicy user1= userService.updateUserPolicy(userpolicyid, user);
		return  ResponseEntity.ok(user1);
	}
	
	 @DeleteMapping("/deleteuserpolicy/{id}")
	 public ResponseEntity<Boolean> deleteUserPolicy(@PathVariable(value = "id") Integer userpolicyid,@RequestBody UserPolicy user) throws ResourceNotFoundException	{
			Boolean user1 = userService.deleteUserPolicyById(userpolicyid);
			return  ResponseEntity.ok(user1);
    }
}