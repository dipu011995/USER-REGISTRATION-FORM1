package com.registration.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.entity.UserRegistrationEntity;

/**
 * This Class extending from JpaRepositeries ,which have some pre defind method
 * to perform CRUD operation
 * 
 *
 */
@Repository
public interface UserRegistrationRepositeries extends JpaRepository<UserRegistrationEntity, Integer> {

	@Query("from UserRegistrationEntity where email = :mail and password = :pwd")
	public UserRegistrationEntity getAccDetaisByEmailAndTempPwd(String mail, String pwd);

	@Query("from UserRegistrationEntity where email = :email and password = :paswword")
	public UserRegistrationEntity getUserByEmailAndOriginalPwd(String email, String paswword);

	@Query("from UserRegistrationEntity where email = :email")
	public UserRegistrationEntity getUserByEmail(String email);
	
//	public UserRegistrationEntity findByEmail(String email);

}
