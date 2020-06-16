package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

	
	@FindBy(xpath="//input[@id='loginform-username']")
	WebElement usertxt;
	
	@FindBy(xpath="//input[@id='loginform-password']")
	WebElement passwordtxt;
	
	@FindBy(xpath="//button[@name='login-button']")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void setusernmae(String username) {
		boolean utxtenabl= usertxt.isEnabled();  
		if(utxtenabl==true) { usertxt.sendKeys(username); }
	}
	public void setpassword(String password) {
		boolean ptxtenabl= passwordtxt.isEnabled();
		if(ptxtenabl==true) { passwordtxt.sendKeys(password); }
	}
	public void loginbuttonclick() {	   
		  loginBtn.click();
	}
}
