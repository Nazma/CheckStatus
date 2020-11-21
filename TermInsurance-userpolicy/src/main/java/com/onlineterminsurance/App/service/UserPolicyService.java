package com.onlineterminsurance.App.service;

import java.util.List;

import com.onlineterminsurance.App.entity.UserPolicy;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;

public interface UserPolicyService {

	public List<UserPolicy> getAllUserPolicies();
	public UserPolicy findUserPolicyById(Integer userpolicyid) throws ResourceNotFoundException;
	public boolean deleteUserPolicyById(Integer userpolicyid)throws ResourceNotFoundException;
	public UserPolicy saveUserPolicy(UserPolicy user);
	public UserPolicy updateUserPolicy(Integer userpolicyid,UserPolicy user)throws ResourceNotFoundException;
	//public List<userPolicy> findByUserIdAndPolicyId(int userId,int policyNo);
}
