package com.diaspogift.identityandaccess.domain.model.identity;

public class User {

	// Attributes
	private ProviderId providerId;
	private Person person;
	private String username;
	private String password;
	private Enablement enablement;

	// Might need a factory

	public User(ProviderId aProviderId, Person aPerson, String aUsername, String aPassword, Enablement andEnablement) {
		this.setProviderId(aProviderId);
		this.setPerson(aPerson);
		this.setPassword(aPassword);
		this.setEnablement(andEnablement);
	}

	// Business logic

	public void protectPassword(String aCurrentPassword, String aChangedPassword) {
		if (this.password != aCurrentPassword) {
			throw new IllegalStateException("Failed current password verification");
		}
	}

	public void changPassword(String aCurrentPassword, String aChangedPassword) {
		protectPassword(aCurrentPassword, aChangedPassword);
		this.setPassword(aChangedPassword);
	}

	public void changePersonalContactInformation(ContactInformation aContactInformation) {
		this.person().changeContactInformation(aContactInformation);
	}

	public void changePersonalName(FullName aFullName) {
		this.person().changeName(aFullName);
	}

	public void defineEnablement(Enablement anEnablement) {
		this.setEnablement(anEnablement);
	}

	public String password() {
		return this.password;
	}

	protected Enablement enablement() {
		return this.enablement;
	}

	public boolean isEnabled() {
		return this.enablement().isEnablementEnabled();
	}

	public Person person() {
		return this.person;
	}

	// Internal setters

	private void setProviderId(ProviderId aProviderId) {
		this.providerId = aProviderId;
	}

	protected void setPerson(Person person) {
		this.person = person;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected void setEnablement(Enablement enablement) {
		this.enablement = enablement;
	}

}
