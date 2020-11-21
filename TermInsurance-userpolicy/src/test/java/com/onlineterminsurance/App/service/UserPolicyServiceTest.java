package com.onlineterminsurance.App.service;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineterminsurance.App.entity.UserPolicy;
import com.onlineterminsurance.App.repository.UserPolicyDaoImpl;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
 class UserPolicyServiceTest {
	 @MockBean
	 private UserPolicyDaoImpl userpolicyDaoImpl;
	
	 @Autowired
	 private UserPolicyService userPolicyService;
	
	 @Test
	 public void testGetUserPolicyById() throws Exception{
		 UserPolicy user=new UserPolicy();
	        user.setUserid(101);
		    user.setPolicyid(401);
		    user.setRegisteredDate("2000-11-10");
	        user.setTotalTime(12);
	        user.setAmount(60000.00);
	        user.setMonthOver(2);
	        user.setAmountPaid(5000.00);


	      Mockito.when(userpolicyDaoImpl.findByUserPolicyId(101)).thenReturn(user);
	    		  //findUserPolicyById()).get()).thenReturn(user);
	        		//Mockito.when(userpolicyDaoImpl.findById(user.getUserpolicyid()).get()).thenReturn(user);
		        assertThat(userPolicyService.findUserPolicyById(101)).isEqualTo(user);
		    }


	@Test
	void testDeleteUserPolicy() throws Exception {
		 UserPolicy user=new UserPolicy();
	        user.setUserid(100);
		    user.setPolicyid(401);
		    user.setRegisteredDate("2000-11-10");
	        user.setTotalTime(12);
	        user.setAmount(60000.00);
	        user.setMonthOver(2);
	        user.setAmountPaid(5000.00);
		userpolicyDaoImpl.deleteById(user.getUserpolicyid());
        System.out.println(userpolicyDaoImpl.findById(100));
        Assert.assertTrue(userpolicyDaoImpl.findById(100).isEmpty());
	}

	@Test
	void testUpdateUserPolicyById() throws Exception {
		 UserPolicy user=new UserPolicy();
	        user.setUserid(101);
		    user.setPolicyid(401);
		    user.setRegisteredDate("2000-11-10");
	        user.setTotalTime(12);
	        user.setAmount(60000.00);
	        user.setMonthOver(2);
	        user.setAmountPaid(5000.00);


		        Mockito.when(userpolicyDaoImpl.findByUserPolicyId(101)).thenReturn(user);
		        user.setAmount(80000.00);
		        Mockito.when(userpolicyDaoImpl.save(user)).thenReturn(user);
		        System.out.println(user.getAmount());
		       // assertThat(userPolicyService.updateUserPolicy(101, user)).isEqualTo(user);
	}

	@Test
	void testGetAllUserPolicies() {
		 UserPolicy user=new UserPolicy();
	        user.setUserid(101);
		    user.setPolicyid(401);
		    user.setRegisteredDate("2000-11-10");
	        user.setTotalTime(12);
	        user.setAmount(60000.00);
	        user.setMonthOver(2);
	        user.setAmountPaid(5000.00);


	        UserPolicy user1=new UserPolicy();
	        user1.setUserid(103);
		    user1.setPolicyid(401);
		    user1.setRegisteredDate("2000-11-10");
	        user1.setTotalTime(12);
	        user1.setAmount(60000.00);
	        user1.setMonthOver(2);
	        user1.setAmountPaid(5000.00);

        List<UserPolicy> userPolicyList = new ArrayList<>();
        userPolicyList.add(user);
        userPolicyList.add(user1);

        Mockito.when(userpolicyDaoImpl.findAll()).thenReturn(userPolicyList);
        assertThat(userPolicyService.getAllUserPolicies()).isEqualTo(userPolicyList);
	}

	@Test
	void testSaveUserPolicy() {
		UserPolicy user=new UserPolicy();
		user.setUserid(108);
	    user.setPolicyid(401);
	    user.setRegisteredDate("2000-11-10");
        user.setTotalTime(12);
        user.setAmount(60000.00);
        user.setMonthOver(2);
        user.setAmountPaid(5000.00);
		
	}
}




