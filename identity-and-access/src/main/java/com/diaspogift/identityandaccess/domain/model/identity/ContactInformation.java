package com.diaspogift.identityandaccess.domain.model.identity;

public class ContactInformation {

	private EmailAddress emailAddress;
	private PostalAdress postalAdress;
	private Telephone primaryTelephone;
	private Telephone secondaryTelephone;
	

	public ContactInformation(EmailAddress anEmailAddress, PostalAdress aPostalAdress, Telephone aPrimaryTelephone,
			Telephone aSecondaryTelephone) {
		
		this.setEmailAddress(anEmailAddress);
		this.setPostalAdress(aPostalAdress);
		this.setPrimaryTelephone(aPrimaryTelephone);	
		this.setSecondaryTelephone(aSecondaryTelephone);

	}

	public ContactInformation() {
		
		super();

	}

	public EmailAddress emailAddress() {
		return this.emailAddress;
	}

	public PostalAdress postalAddress() {
		return this.postalAdress;
	}

	public Telephone primaryTelephone() {
		return this.primaryTelephone;
	}

	public Telephone secondaryTelephone() {
		return this.secondaryTelephone;
	}

	private void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	private void setPostalAdress(PostalAdress postalAdress) {
		this.postalAdress = postalAdress;
	}

	private void setPrimaryTelephone(Telephone primaryTelephone) {
		this.primaryTelephone = primaryTelephone;
	}

	private void setSecondaryTelephone(Telephone secondaryTelephone) {
		this.secondaryTelephone = secondaryTelephone;
	}
	
	

}
