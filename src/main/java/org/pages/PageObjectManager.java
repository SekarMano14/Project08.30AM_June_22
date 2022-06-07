package org.pages;

public class PageObjectManager {
	
	private PageObjectManager() {
		
	}

	private static PageObjectManager manager;
	private  LoginPage loginPage;
	private  RegistrationPage registrationPage;
	
	public static PageObjectManager getManager() {
		if(manager==null) {
			manager= new PageObjectManager();
		}
		return manager;
	}
	public  LoginPage getLoginPage() {
		return loginPage==null? loginPage=new LoginPage():loginPage;
	}
	public  RegistrationPage getRegistrationPage() {
		return registrationPage==null?registrationPage=new RegistrationPage():registrationPage;
	}
	
	

//	?--ternanary operator
//	condition?statement1: statement2
//	           true            false
	
	
}
