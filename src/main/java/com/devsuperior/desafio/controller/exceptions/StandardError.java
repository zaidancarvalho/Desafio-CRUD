package com.devsuperior.desafio.controller.exceptions;

import java.time.Instant;

public class StandardError {

	private Instant timestamp;
	private Integer Status;
	private String error;
	private String path;
	
	public StandardError(Instant timestamp, Integer status, String error, String path) {
		super();
		this.timestamp = timestamp;
		Status = status;
		this.error = error;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
