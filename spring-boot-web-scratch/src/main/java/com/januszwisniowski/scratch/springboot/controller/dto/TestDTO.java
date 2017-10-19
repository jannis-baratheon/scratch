package com.januszwisniowski.scratch.springboot.controller.dto;

import java.time.ZonedDateTime;

public class TestDTO {
	private ZonedDateTime aDateTime;

	private String aField;

	public String getAField() {
		return aField;
	}

	public void setAField(String aField) {
		this.aField = aField;
	}
	public ZonedDateTime getADateTime() {
		return aDateTime;
	}
	public void setADateTime(ZonedDateTime aDateTime) {
		this.aDateTime = aDateTime;
	}
}
