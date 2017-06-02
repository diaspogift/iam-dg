package com.diaspogift.identityandaccess.domain.model.identity;

public class FullName {

	private String firstName;
	private String middleName;
	private String lastName;

	public FullName() {
	}

	public FullName(String aFirstName, String aMiddleName, String aLastName) {

		this.setFirstName(aFirstName);
		this.setMiddleName(aMiddleName);
		this.setLastName(aLastName);
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Internal setters

	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		return result;
	}

	// HashCode and Equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullName other = (FullName) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		return true;
	}

}
