package pages;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkerPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='workersearch-first_name']")
	WebElement fnametxt;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement SearchBtn;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement ResetBtn;
	
	 
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tr[2]//td//a[@title='View']")
	WebElement viewLink;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tr[2]//td//a[@title='Update']")
	WebElement editLink;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tr[2]//td//a[@title='Delete']")
	WebElement deleteLink;
	
	
	
	public WorkerPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setfname(String fname) {
		fnametxt.sendKeys(fname);
	}
	public void SearchClick() {	   
		SearchBtn.submit();
	}
	public void ViewClick() {	   
		viewLink.click();
	}
	public void EditClick() {	   
		editLink.click();
	}
	public void DeleteClick() {	   
		deleteLink.click();
	}

}
