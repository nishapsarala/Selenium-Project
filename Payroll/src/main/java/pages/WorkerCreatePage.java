package pages;
 
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class WorkerCreatePage {
WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Workers')]")
	WebElement workerLink;
	
	@FindBy(xpath="//a[contains(text(),'Create Worker')]")
	WebElement createWorkerLink;
		
	@FindBy(xpath="//select[@id='worker-title']")
	WebElement title;
	
	@FindBy(xpath="//select[@id='worker-gender']")
	WebElement gender;
	
	@FindBy(xpath="//select[@id='worker-branch_id']")
	WebElement branch;
	
	@FindBy(xpath="//input[@id='worker-first_name']")
	WebElement fnametxt;
	
	@FindBy(xpath="//input[@id='worker-last_name']")
	WebElement lnametxt;
	
	@FindBy(xpath="//input[@id='worker-address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='worker-phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='worker-ni_number']")
	WebElement niNo;
	
	@FindBy(xpath="//input[@id='worker-email']")
	WebElement emailtxt;
	
	@FindBy(xpath="//input[@id='worker-dob']")
	WebElement dobTxt;
	
	@FindBy(xpath="//input[@id='worker-postcode']")
	WebElement pcode;
	
	@FindBy(xpath="//select[@id='worker-division_id']")
	WebElement division;
	
	@FindBy(xpath="//select[@id='worker-employment_type']")
	WebElement etype;
	
	@FindBy(xpath="//select[@id='worker-payslip_method']")
	WebElement pslip;
	
	@FindBy(xpath="//button[@class='btn btn-success' and text()='Next']")
	WebElement nxtBtnNext;
	
	@FindBy(xpath="//button[@class='btn btn-success' and text()='Save']")
	WebElement nxtBtnSave;
	
	@FindBy(xpath="//input[@id='worker-ac_name']") 
	WebElement acNametxt;
	
	@FindBy(xpath="//input[@id='worker-ac_no']")
	WebElement acNotxt;
	
	@FindBy(xpath="//input[@id='worker-sort_code']")
	WebElement sortCodetxt;
	
	@FindBy(xpath="//table[@id='w0']//tr//td")
	private List<WebElement> colmvalues;
	   
	
	public WorkerCreatePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String[] colmValues()  { 
		 
	      String act[] = new String[6];
	      for(int i=0;i<6;i++) {
	    	   act[i] =colmvalues.get(i).getText();
	    	   
	      } 
	  return act;
	} 
	public void clickWorkerLink() {
		workerLink.click();
	}
	public void clkCreateWorkerLink() {
		createWorkerLink.click();
	}
	public void title() {
		Select ob= new Select(title);
		ob.selectByIndex(2);
	}
	public void gender() {
		Select ob1= new Select(gender);
		ob1.selectByIndex(1);
	}
	public void branch() {
		Select ob2= new Select(branch);
		ob2.selectByIndex(1);
	}
	public void setfname(String fname) {
		fnametxt.clear();
		fnametxt.sendKeys(fname);
	}
	public void phone(String phoneNo) {
		phone.clear();
		phone.sendKeys(phoneNo);
	}
	public void postCode(String postCode) {
		pcode.clear();
		pcode.sendKeys(postCode);
	}
	public void setaddress(String address1) {
		address.clear();
		address.sendKeys(address1);
	}	
	public void niNo(String nimum) {
		niNo.clear();
		niNo.sendKeys(nimum);
	}
	public void setEmail(String email) {
		emailtxt.clear();
		emailtxt.sendKeys(email);
	}
	public void setDob(String dob) {
		dobTxt.clear();
		dobTxt.sendKeys(dob);
	}
	public void setlname(String lname) {
		lnametxt.clear();
		lnametxt.sendKeys(lname);
	}	
	public void empType() {
		Select ob3= new Select(etype);
		ob3.selectByIndex(2);
	}	
	public void division() {
		Select ob4= new Select(division);
		ob4.selectByIndex(1);
	}
	public void paySlip() {
		Select ob5= new Select(pslip);
		ob5.selectByIndex(2);
	}
	public void setAcName(String actName) {
		acNametxt.clear();
		acNametxt.sendKeys(actName);
	}
	public void setAcNo(String accNo) {
		acNotxt.clear();
		acNotxt.sendKeys(accNo);
	}
	public void setCode(String scode) {
		sortCodetxt.clear();
		sortCodetxt.sendKeys(scode);
	}	
	public void nxtClick() {	   
		nxtBtnNext.submit();
	}
	public void SaveClick() {	   
		nxtBtnSave.submit();
	}
	
}
