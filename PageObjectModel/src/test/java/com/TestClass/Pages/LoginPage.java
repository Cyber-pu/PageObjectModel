package com.TestClass.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.TestClass.Utils.CommanUtils;

public class LoginPage extends CommanUtils{
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public By name=By.name("uid");
	public By pass=By.name("password");
	public By submit=By.name("btnLogin");
	public By validpage=By.xpath("//ul[@class='menusubnav']/li[2]");
	
	public void loginPage(String url,String user,String password) {
		navigate(url);
		sendKeys(name, user);
		sendKeys(pass, password);
		clikElement(submit);
		validPage(getElementText(validpage),"New Customer");	
	}

	
	
}
