package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class RegistrationPage extends BaseClass {
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@role='button'])[2]")
	private WebElement btnCreate;
	
	@FindBy(name = "firstname")
	private WebElement txtFirstname;
	
	@FindBy(name = "lastname")
	private WebElement txtlastname;
	
	@FindBy(name = "websubmit")
	private WebElement btnSignUp;

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getBtnSignUp() {
		return btnSignUp;
	}
	
	

}
