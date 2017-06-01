package com.diaspogift.identityandaccess.domain.model.identity;


public class User {
	
	private UserId userId;
	private ProviderId providerId;
	private Person person;
	private String username;
	private String password;
	private Enablement enablement;
	
	
	
	//Might need a factory
	
	public User(UserId userId2, ProviderId providerId2, Person person2, String username,  String password, Enablement enablement) {
		
		this.username = username;
		this.password = password;
		this.enablement = enablement;
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










	
	//private getters and setters


	

}
