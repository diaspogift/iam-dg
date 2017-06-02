package com.diaspogift.identityandaccess.domain.model.identity;

import java.time.ZonedDateTime;

public class Enablement {

	private boolean enabled;
	private ZonedDateTime startDateTime;
	private ZonedDateTime endDateTime;

	public Enablement() {
	}

	public Enablement(boolean anEnabled, ZonedDateTime today, ZonedDateTime tomorrow) {

		this.setEnabled(anEnabled);
		this.setStartDate(today);
		this.setEndDate(tomorrow);
	}

	public Enablement(Enablement anEnablement) {
		this(anEnablement.isEnabled(), anEnablement.startDateTime(), anEnablement.endDateTime());
	}

	// business logic
	public boolean isEnablementTimeExpired() {

		boolean enablementTimeExpire = false;

		if (this.startDateTime() != null && this.endDateTime() != null) {

			ZonedDateTime now = ZonedDateTime.now();

			if (now.isBefore(this.startDateTime()) || now.isAfter(this.endDateTime())) {

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

	public ZonedDateTime endDateTime() {
		return this.endDateTime;
	}

	public ZonedDateTime startDateTime() {
		return this.startDateTime;
	}

	// private setters
	private void setEnabled(boolean anEnabled) {
		this.enabled = anEnabled;
	}

	private void setEndDate(ZonedDateTime anEndDateTime) {
		this.endDateTime = anEndDateTime;
	}

	private void setStartDate(ZonedDateTime aStartDateTime) {
		this.startDateTime = aStartDateTime;
	}

}
