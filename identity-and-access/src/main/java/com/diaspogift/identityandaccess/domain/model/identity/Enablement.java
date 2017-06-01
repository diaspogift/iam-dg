package com.diaspogift.identityandaccess.domain.model.identity;

import java.time.LocalDate;
import java.util.Date;

public class Enablement {

	private boolean enabled;
	private LocalDate startDate;
	private LocalDate endDate;

	// Construstors
	public Enablement() {
	}

	public Enablement(boolean anEnabled, LocalDate today, LocalDate tomorrow) {

		// To Do: validate state

		this.setEnabled(anEnabled);
		this.setStartDate(today);
		this.setEndDate(tomorrow);
	}

	public Enablement(Enablement anEnablement) {
		this(anEnablement.isEnabled(), anEnablement.startDate(), anEnablement.endDate());
	}

	// business logic
	public boolean isEnablementTimeExpired() {

		boolean enablementTimeExpire = false;

		if(this.startDate() != null && this.endDate() != null)
		{
			LocalDate now = LocalDate.now();

			if (now.isBefore(this.startDate()) || now.isAfter(this.endDate())) {

				enablementTimeExpire = true;

			}
		}


		return enablementTimeExpire;

	}

	public boolean isEnabled() {

		return this.enabled;
	}

	public boolean isEnablementEnabled() {

		boolean enabled = false;

		if (this.isEnabled()) {
			if (!this.isEnablementTimeExpired()) {
				enabled = true;
			}
		}
		return enabled;

	}

	public LocalDate endDate() {
		return this.endDate;
	}

	public LocalDate startDate() {
		return this.startDate;
	}

	// private setters
	private void setEnabled(boolean anEnabled) {
		this.enabled = anEnabled;
	}

	private void setEndDate(LocalDate anEndDate) {
		this.endDate = anEndDate;
	}

	private void setStartDate(LocalDate aStartDate) {
		this.startDate = aStartDate;
	}

}
