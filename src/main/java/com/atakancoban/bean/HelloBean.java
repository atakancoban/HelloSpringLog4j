package com.atakancoban.bean;

import java.io.Serializable;
import java.util.jar.Attributes.Name;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atakancoban.service.CarService;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = -4823295172962937652L;

	@ManagedProperty("#{carService}")
	private CarService carService;
	
	static Logger logger = Logger.getLogger(HelloBean.class);
	
	private String message = "www.atakancoban.com";

	@PostConstruct
	public void init() {
		System.out.println("init()");
	}

	public void onClick() {
		try {

			System.out.println("Araba Listesi  : " + carService.getCarDetails());

			System.out.println("Veritabanı ile çekilen zaman   : " + carService.getSystemTime());
			 logger.trace("Bu bir TRACE mesajı ");
		        logger.debug("Bu bir DEBUG mesajı ");
		        logger.info("Bu bir INFO mesajı ");
		        logger.warn("Bu bir WARN mesajı ");
		        logger.error("Bu bir ERROR mesajı ");
		        logger.fatal("Bu bir FATAL mesajı ");
		} catch (Exception e) {
			System.out.println("Exception onClick() " + e.getMessage());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}



}
