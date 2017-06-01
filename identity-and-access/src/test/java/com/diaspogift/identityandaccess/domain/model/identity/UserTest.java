package com.diaspogift.identityandaccess.domain.model.identity;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Period;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Test
	public void test_user_enablement_enabled(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person();
		Enablement enablement = new Enablement(true, null, null);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertTrue(user.isEnabled());
		
	}
	
	@Test
	public void test_user_enablement_disabled(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person();
		Enablement enablement = new Enablement(false, null, null);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertFalse(user.isEnabled());
		
	}
	
	@Test 
	public void test_user_enablement_within_start_and_end_date(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		Enablement enablement = new Enablement(true, today, tomorrow);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertTrue(user.isEnabled());

	}
	
	@Test 
	public void test_user_enablement_outside_start_and_end_date(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person();
		LocalDate nowMinusFiveDays = LocalDate.now().minus(Period.ofDays(5));
		LocalDate nowMinusFourDays = LocalDate.now().minus(Period.ofDays(4));


		Enablement enablement = new Enablement(true, nowMinusFiveDays, nowMinusFourDays);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertFalse(user.isEnabled());
		
		
		
		LocalDate nowPlusFiveDays = LocalDate.now().plus(Period.ofDays(5));
		LocalDate nowPlusFourDays = LocalDate.now().plus(Period.ofDays(4));

		
		Enablement enablement1 = new Enablement(true, nowPlusFourDays, nowPlusFiveDays);
		User user1 = new User(userId, providerId, person, "bob", "secret", enablement1);
		
		
		assertFalse(user1.isEnabled());

	}

	@Test
	public void test_user_change_password() {

		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person();
		Enablement enablement = new Enablement();
		String aCurrentPassword = "secret";
		String aChangedPassword = "password";

		User user = new User(userId, providerId, person, "bob", "secret", enablement);

		user.changPassword(aCurrentPassword, aChangedPassword);

		assertEquals(user.password(), aChangedPassword);

	}

}
