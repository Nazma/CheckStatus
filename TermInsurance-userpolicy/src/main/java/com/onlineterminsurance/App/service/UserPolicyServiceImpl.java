package com.onlineterminsurance.App.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineterminsurance.App.entity.UserPolicy;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;
import com.onlineterminsurance.App.repository.UserPolicyDaoImpl;

@Service
@Transactional
public class UserPolicyServiceImpl implements UserPolicyService{

	@Autowired
	private UserPolicyDaoImpl userpolicy;
	

	public List<UserPolicy> getAllUserPolicies(){
		return userpolicy.findAll();
	}

	public UserPolicy findUserPolicyById(@PathVariable(value="id")Integer userpolicyid) throws ResourceNotFoundException {
	
		UserPolicy user =userpolicy.findByUserPolicyId(userpolicyid);
		if(user==null)
		{
			new ResourceNotFoundException("User Policy not found for this id :: " + userpolicyid);
		}
		return user;
	}

   /*public List<userPolicy> findByUserIdAndPolicyId(int userId,int policyNo) {
        return (List<userPolicy>) userpolicy.findByUserIdAndPolicyId(userId, policyNo);
    }*/
    public boolean deleteUserPolicyById(Integer userpolicyid) throws ResourceNotFoundException {
    	UserPolicy user = userpolicy.findById(userpolicyid)
				.orElseThrow(() -> new ResourceNotFoundException("User Policy ot found for this id :: " + userpolicyid));
    	 userpolicy.delete(user);
    	 if(null == user){
	            return true;
	        }
	        return false;
    }
			

	public UserPolicy saveUserPolicy(UserPolicy user) {
		
		return userpolicy.save(user);
	}

	public UserPolicy updateUserPolicy(Integer userpolicyid,UserPolicy user) throws ResourceNotFoundException {
		UserPolicy user1 = userpolicy.findById(userpolicyid)
				.orElseThrow(() -> new ResourceNotFoundException("User Policy not found for this id :: " + userpolicyid));
		user1.setUserid(user.getUserid());
		user1.setPolicyid(user.getPolicyid());
		user1.setRegisteredDate(user.getRegisteredDate());
		user1.setAmount(user.getAmount());
		user1.setTotalTime(user.getTotalTime());
		user1.setMonthOver(user.getMonthOver());
		user1.setAmountPaid(user.getAmountPaid());
		final UserPolicy updateduserPolicy =userpolicy.save(user1);
		return updateduserPolicy;
	}
	

	public List<UserPolicy> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}


