package com.diaspogift.identityandaccess.domain.model.identity;

public class PostalAdress {
	
	
	private String streetAddress;
	private String city;
	private String stateProvinceRegion;
	private String postalCode;
	private String countyCommuneCode;
	

	public PostalAdress(String aStreetAddress, String aCity, String aStateProvinceRegion, String aPostalCode, String aCountyCommuneCode) {
		
		this.setStreetAddress(aStreetAddress);
		this.setCity(aCity);
		this.setStateProvinceRegion(aStateProvinceRegion);
		this.setPostalCode(aPostalCode);
		this.setCountyCommuneCode(aCountyCommuneCode);
	}

	public String streetAddress() {
		return this.streetAddress;
	}

	public String city() {
		return this.city;
	}

	public String stateProvinceRegion() {
		return this.stateProvinceRegion;
	}

	public String postalCode() {
		return this.postalCode;
	}

	public String countyCommuneCode() {
		return this.countyCommuneCode;
	}

	
	
	
	
	
	///Internal setters
	
	private void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	private void setCity(String city) {
		this.city = city;
	}

	private void setStateProvinceRegion(String stateProvinceRegion) {
		this.stateProvinceRegion = stateProvinceRegion;
	}

	private void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	private void setCountyCommuneCode(String countyCommuneCode) {
		this.countyCommuneCode = countyCommuneCode;
	}
	
	
	
	
	
	//Equals and Hash

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((countyCommuneCode == null) ? 0 : countyCommuneCode.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((stateProvinceRegion == null) ? 0 : stateProvinceRegion.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
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
		PostalAdress other = (PostalAdress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (countyCommuneCode == null) {
			if (other.countyCommuneCode != null)
				return false;
		} else if (!countyCommuneCode.equals(other.countyCommuneCode))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (stateProvinceRegion == null) {
			if (other.stateProvinceRegion != null)
				return false;
		} else if (!stateProvinceRegion.equals(other.stateProvinceRegion))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		return true;
	}
	


	
	
	
	
	

}
