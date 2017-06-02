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
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
		Enablement enablement = new Enablement(true, null, null);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertTrue(user.isEnabled());
		
	}
	
	@Test
	public void test_user_enablement_disabled(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
		Enablement enablement = new Enablement(false, null, null);
		User user = new User(userId, providerId, person, "bob", "secret", enablement);
		
		assertFalse(user.isEnabled());
		
	}
	
	@Test 
	public void test_user_enablement_within_start_and_end_date(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
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
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
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
	public void test_user_enablement_with_unsequence_date(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
		LocalDate nowPlusFiveDays = LocalDate.now().plus(Period.ofDays(5));
		LocalDate nowPlusFourDays = LocalDate.now().plus(Period.ofDays(4));
		
		
		Enablement enablement1 = new Enablement(true, nowPlusFiveDays,nowPlusFourDays );
		User user1 = new User(userId, providerId, person, "bob", "secret", enablement1);
		
		assertFalse(user1.isEnabled());


	}

	@Test
	public void test_user_change_password() {

		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
		Enablement enablement = new Enablement();
		String aCurrentPassword = "secret";
		String aChangedPassword = "password";

		User user = new User(userId, providerId, person, "bob", "secret", enablement);

		user.changPassword(aCurrentPassword, aChangedPassword);

		assertEquals(user.password(), aChangedPassword);

	}
	
	//To Do might need a meaningfull exception
	@Test(expected=IllegalStateException.class)
	public void test_user_change_password_fails() {

		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation());
		Enablement enablement = new Enablement();
		String aCurrentPassword = "I do not knot";
		String aChangedPassword = "password";

		User user = new User(userId, providerId, person, "bob", "secret", enablement);

		user.changPassword(aCurrentPassword, aChangedPassword);


	}
	
	
	@Test
	public void test_user_change_personnal_contact(){
		
		//To Do:need a factory
		UserId userId = new UserId();
		ProviderId providerId = new ProviderId();
		Person person = new Person(new FullName(), new ProviderId(), new ContactInformation( new EmailAddress("nn example@gmail.com"), 
				  new PostalAdress( "ggg Carrefour 3 boutiques",
				  			"nn Douala",
				  			"nnn Litoral",
				  			"nn 80301",
				  			"nn CMR"),
		  new Telephone("nn 669262656"),
		  new Telephone("nn 689989034")));
		Enablement enablement = new Enablement();

		User user = new User(userId, providerId, person, "bob", "secret", enablement);

		user.changePersonalContactInformation(new ContactInformation( new EmailAddress("example@gmail.com"), 
																	  new PostalAdress( "Carrefour 3 boutiques",
																			  			"Douala",
																			  			"Litoral",
																			  			"80301",
																			  			"CMR"),
																	  new Telephone("669262656"),
																	  new Telephone("689989034")));

		assertEquals(new EmailAddress("example@gmail.com"), user.person().contactInformation().emailAddress());
        assertEquals(new PostalAdress( "Carrefour 3 boutiques",
	  			"Douala",
	  			"Litoral",
	  			"80301",
	  			"CMR"), user.person().contactInformation().postalAddress());
        assertEquals(new Telephone("669262656"), user.person().contactInformation().primaryTelephone());
        assertEquals(new Telephone("689989034"), user.person().contactInformation().secondaryTelephone());

        


	}
	
	@Test
	public void test_user_personal_name_change(){
		
		
		//To Do:need a factory
				UserId userId = new UserId();
				ProviderId providerId = new ProviderId();
				Person person = new Person(new FullName("John", "Peter", "Sanders"), new ProviderId(), new ContactInformation( new EmailAddress("nn example@gmail.com"), 
						  new PostalAdress( "ggg Carrefour 3 boutiques",
						  			"nn Douala",
						  			"nnn Litoral",
						  			"nn 80301",
						  			"nn CMR"),
				  new Telephone("nn 669262656"),
				  new Telephone("nn 689989034")));
				Enablement enablement = new Enablement();

				User user = new User(userId, providerId, person, "bob", "secret", enablement);
				
				
				user.changePersonalName(new FullName("John", "Peter", "Sanders"));
				
				assertEquals(new FullName("John", "Peter", "Sanders"), user.person().fullName());
				
				
		
		
	}
	

}
