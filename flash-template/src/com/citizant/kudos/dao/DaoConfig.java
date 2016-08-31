package com.citizant.kudos.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.citizant.kudos.dao.impl.KudoDaoImpl;



@Configuration
public class DaoConfig {
	
	@Bean
	public KudoDao kudoDao(){
		return new KudoDaoImpl();
	}
	
}
