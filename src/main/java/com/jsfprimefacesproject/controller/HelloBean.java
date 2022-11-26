package com.jsfprimefacesproject.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.jsfprimefacesproject.model.Hello;

@Named
@ViewScoped
public class HelloBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Hello hello;

	private List<Hello> helloList = new ArrayList<>();

	private LocalDateTime now = LocalDateTime.now();
	
	private String text;

	@PostConstruct
	public void init() {
		hello = new Hello();
		hello.setUser("User");
		hello.setMessage("Hello");

		for (int i = 0; i < 10; i++) {
			Hello hello = new Hello();
			hello.setUser("User " + i);
			hello.setMessage("Hello " + i);
			helloList.add(hello);
		}

	}
	
	public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
	
	public void openDialog() {
		System.out.print(this.getText());
		PrimeFaces.current().executeScript("PF('dlg1').show()");
	}
	

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

	public List<Hello> getHelloList() {
		return helloList;
	}

	public void setHelloList(List<Hello> helloList) {
		this.helloList = helloList;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
