package com.tdd.api.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tdd.api.domain.exceptions.InvalidArgumentException;

final public class CourseTitle {
	private String value;

	@JsonCreator
	public CourseTitle(@JsonProperty("value") String value) throws InvalidArgumentException {
		// We should ensure title is valid
		ensureTitleIsValid(value);
		this.value = value;
	}

	private void ensureTitleIsValid(String title) throws InvalidArgumentException {
		if (title.isBlank()) {
			throw new InvalidArgumentException("Course title does not have valid format: " + title);
		}
		try {
			Integer.parseInt(title);
			throw new InvalidArgumentException("Course title does not have valid format: " + title);
		}catch(NumberFormatException exp) {
		}
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseTitle other = (CourseTitle) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return this.value;
	}

}
