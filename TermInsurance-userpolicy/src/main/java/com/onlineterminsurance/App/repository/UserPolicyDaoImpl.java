package com.onlineterminsurance.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineterminsurance.App.entity.UserPolicy;

@Repository
public interface UserPolicyDaoImpl extends JpaRepository<UserPolicy,Integer> {
 @Query(value="select * from user_policy where user_policy_id=?1",nativeQuery=true)
  UserPolicy findByUserPolicyId(int userpolicyid);
}
