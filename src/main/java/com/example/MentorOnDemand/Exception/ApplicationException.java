package com.example.MentorOnDemand.Exception;

public class ApplicationException extends Exception {
	String exceptionerror;

	public ApplicationException(String error) {
		this.exceptionerror = error;
	}

	public String toString() {
		return " There is some problem due to " + exceptionerror;
	}

}
