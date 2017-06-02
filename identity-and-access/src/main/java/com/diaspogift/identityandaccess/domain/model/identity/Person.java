package com.diaspogift.identityandaccess.domain.model.identity;

public class Person {

	private FullName fullName;
	private ProviderId providerId;
	private ContactInformation contactInformation;

	public Person(FullName aFullName, ProviderId aProviderId, ContactInformation aContactInformation) {
		super();
		this.setFullName(aFullName);
		this.setProviderId(aProviderId);
		this.setContactInformation(aContactInformation);
	}



	//
	
	private void setFullName(FullName aFullName) {
		this.fullName = aFullName;
	}

	private void setProviderId(ProviderId aProviderId) {
		this.providerId = aProviderId;
	}

	private void setContactInformation(ContactInformation aContactInformation) {
		this.contactInformation = aContactInformation;
	}



	public EmailAddress emailAddress() {

		return this.contactInformation().emailAddress();
	}



	public ContactInformation contactInformation() {
		return this.contactInformation;
	}



	public void changeContactInformation(ContactInformation aContactInformation) {
		
		this.setContactInformation(aContactInformation);
	}



	public FullName fullName() {
		return this.fullName;
	}

}
