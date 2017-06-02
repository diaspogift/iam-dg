package com.diaspogift.identityandaccess.domain.model.identity;

public class EmailAddress {

	private String emailAddress;

	public EmailAddress(String anEmailAddress) {

		this.setEmailAddress(anEmailAddress);

	}

	private void setEmailAddress(String anEmailAddress) {
		this.emailAddress = anEmailAddress;
	}

	// Hash and Equal

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
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
		EmailAddress other = (EmailAddress) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		return true;
	}

}
