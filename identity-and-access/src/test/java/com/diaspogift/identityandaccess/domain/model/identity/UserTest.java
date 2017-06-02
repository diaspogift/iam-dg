package com.diaspogift.identityandaccess.domain.model.identity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Period;
import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Test
	public void test_user_enablement_enabled() {

		Enablement enablement = new Enablement(true, null, null);
		User user = new User(null, null, null, null, enablement);

		assertTrue(user.isEnabled());
	}

	@Test
	public void test_user_enablement_disabled() {

		Enablement enablement = new Enablement(false, null, null);
		User user = new User(null, null, null, null, enablement);

		assertFalse(user.isEnabled());
	}

	@Test
	public void test_user_enablement_within_start_and_end_date() {

		ZonedDateTime today = ZonedDateTime.now();
		ZonedDateTime tomorrow = ZonedDateTime.now().plusDays(1);
		Enablement enablement = new Enablement(true, today, tomorrow);
		User user = new User(null, null, null, null, enablement);

		assertTrue(user.isEnabled());

	}

	@Test
	public void test_user_enablement_outside_start_and_end_date() {

		ZonedDateTime nowMinusFiveDays = ZonedDateTime.now().minus(Period.ofDays(5));
		ZonedDateTime nowMinusFourDays = ZonedDateTime.now().minus(Period.ofDays(4));

		Enablement enablement = new Enablement(true, nowMinusFiveDays, nowMinusFourDays);
		User user = new User(null, null, null, null, enablement);

		assertFalse(user.isEnabled());

		ZonedDateTime nowPlusFiveDays = ZonedDateTime.now().plus(Period.ofDays(5));
		ZonedDateTime nowPlusFourDays = ZonedDateTime.now().plus(Period.ofDays(4));

		Enablement enablement1 = new Enablement(true, nowPlusFourDays, nowPlusFiveDays);
		User user1 = new User(null, null, null, null, enablement1);

		assertFalse(user1.isEnabled());
	}

	@Test
	public void test_user_enablement_with_unsequence_date() {

		ZonedDateTime nowPlusFiveDays = ZonedDateTime.now().plus(Period.ofDays(5));
		ZonedDateTime nowPlusFourDays = ZonedDateTime.now().plus(Period.ofDays(4));

		Enablement enablement1 = new Enablement(true, nowPlusFiveDays, nowPlusFourDays);
		User user1 = new User(null, null, null, null, enablement1);

		assertFalse(user1.isEnabled());
	}

	@Test
	public void test_user_change_password() {

		String aCurrentPassword = "secret";
		String aChangedPassword = "password";

		User user = new User(null, null, null, "secret", null);

		user.changPassword(aCurrentPassword, aChangedPassword);

		assertEquals(user.password(), aChangedPassword);
	}

	@Test(expected = IllegalStateException.class)
	public void test_user_change_password_fails() {

		String aCurrentPassword = "I do not knot";
		String aChangedPassword = "password";

		User user = new User(null, null, "bob", "secret", null);

		user.changPassword(aCurrentPassword, aChangedPassword);

	}

	@Test
	public void test_user_change_personnal_contact() {

		// To Do:need a factory
		Person person = new Person(new FullName(), new ProviderId(),
				new ContactInformation(new EmailAddress("nn example@gmail.com"),
						new PostalAdress("ggg Carrefour 3 boutiques", "nn Douala", "nnn Litoral", "nn 80301", "nn CMR"),
						new Telephone("nn 669262656"), new Telephone("nn 689989034")));

		User user = new User(null, person, null, null, null);

		user.changePersonalContactInformation(new ContactInformation(new EmailAddress("example@gmail.com"),
				new PostalAdress("Carrefour 3 boutiques", "Douala", "Litoral", "80301", "CMR"),
				new Telephone("669262656"), new Telephone("689989034")));

		assertEquals(new EmailAddress("example@gmail.com"), user.person().contactInformation().emailAddress());
		assertEquals(new PostalAdress("Carrefour 3 boutiques", "Douala", "Litoral", "80301", "CMR"),
				user.person().contactInformation().postalAddress());
		assertEquals(new Telephone("669262656"), user.person().contactInformation().primaryTelephone());
		assertEquals(new Telephone("689989034"), user.person().contactInformation().secondaryTelephone());
	}

	@Test
	public void test_user_personal_name_change() {

		Person person = new Person(new FullName("John", "Peter", "Sanders"), new ProviderId(),
				new ContactInformation(new EmailAddress("nn example@gmail.com"),
						new PostalAdress("ggg Carrefour 3 boutiques", "nn Douala", "nnn Litoral", "nn 80301", "nn CMR"),
						new Telephone("nn 669262656"), new Telephone("nn 689989034")));

		User user = new User(null, person, null, null, null);

		user.changePersonalName(new FullName("Felicien", "NA", "Fotio Manfo"));

		assertEquals(new FullName("Felicien", "NA", "Fotio Manfo"), user.person().fullName());

	}

}
