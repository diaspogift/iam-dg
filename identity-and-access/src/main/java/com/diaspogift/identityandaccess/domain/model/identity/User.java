package com.diaspogift.identityandaccess.domain.model.identity;


public class User {
	
	private UserId userId;
	private ProviderId providerId;
	private Person person;
	private String username;
	
	
	private String password;
	private Enablement enablement;
	
	
	
	//Might need a factory
	public User(UserId aUserId, ProviderId aProviderId, Person aPerson, String aUsername,  String aPassword, Enablement andEnablement) {
		
		this.setUserId(aUserId);
		this.setProviderId(aProviderId);
		this.setPerson(aPerson);
		this.setPassword(aPassword);
		this.setEnablement(andEnablement);
	}





	public void changPassword(String aCurrentPassword, String aChangedPassword){
		
		if(this.password != aCurrentPassword)
		{
			throw new IllegalStateException("Failed password verification");
		}
		
		this.password = aChangedPassword;
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





	public void changePersonalContactInformation(ContactInformation aContactInformation) {

			this.person().changeContactInformation(aContactInformation);
			
	}





	public Person person() {
		return this.person;
	}




	
	//private getters and setters


	private void setUserId(UserId userId) {
		this.userId = userId;
	}





	private void setProviderId(ProviderId providerId) {
		this.providerId = providerId;
	}





	private void setPerson(Person person) {
		this.person = person;
	}





	private void setUsername(String username) {
		this.username = username;
	}





	private void setPassword(String password) {
		this.password = password;
	}





	private void setEnablement(Enablement enablement) {
		this.enablement = enablement;
	}





	public void changePersonalName(FullName fullName) {
		// TODO Auto-generated method stub
		
	}










	


	

}
