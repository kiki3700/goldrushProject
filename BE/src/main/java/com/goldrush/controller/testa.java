package com.goldrush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
public class testa {
	@Value("${app.ip}")
	private  String v;

	
	
	public testa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public testa(String v) {
		super();
		this.v = v;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

}
