package com.citizant.kudos.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.citizant.kudos.service.impl.AwsEmailServiceImpl;

import com.citizant.kudos.service.impl.KudoServiceImpl;


@Configuration
@EnableScheduling
public class ServiceConfig {

	@Bean
	public EmailService emailService() {
		return new AwsEmailServiceImpl ();
	}
	
	@Bean
	public KudoService kudoService(){
		return new KudoServiceImpl ();
	}
}
