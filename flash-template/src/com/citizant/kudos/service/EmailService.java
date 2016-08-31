package com.citizant.kudos.service;

public interface EmailService {
	public boolean sendMail(String to, String from, String url);
}
