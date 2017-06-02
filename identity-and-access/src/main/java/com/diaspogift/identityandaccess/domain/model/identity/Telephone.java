package com.diaspogift.identityandaccess.domain.model.identity;

public class Telephone {
	
	private String number;

	public Telephone(String aTelephoneNumber) {

		this.setNumber(aTelephoneNumber);
	}
	
    public String number() {
        return this.number;
    }

    
    //Internal setters
    
	private void setNumber(String number) {
		this.number = number;
	}
	
	//Equals and Hash

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telephone other = (Telephone) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

    

    
	

}
