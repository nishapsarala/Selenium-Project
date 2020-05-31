package test;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pages.LoginPage;
import pages.WorkerCreatePage;
import utility.ExcelData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert; 

public class WorkerCreateTest extends Base{
	 @Test(dataProvider = "logintestdata")
	public void verifyWorkerForm(String username,String password) {
		  LoginPage l =new LoginPage(driver);
		  l.setusernmae(username);
		  l.setpassword(password);
		  l.loginbuttonclick();	  
		  
		  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		  String actualTitle = driver.getTitle(); 	
		  String expTitle = "Payroll Application";
		  Assert.assertEquals(actualTitle, expTitle); 
		  
		  WorkerCreatePage w=new WorkerCreatePage(driver);
		  w.clickWorkerLink();
		  w.clkCreateWorkerLink();
		  w.title();
		  w.gender();
		  w.branch();
		  w.setfname("manujohn");
		  w.division();
		  w.setlname("v");
		  w.setDob("28-04-2020");
		  w.empType();
		  w.setaddress("MRE 22/1, Test, Attinga");
		  w.paySlip();
		  w.phone("8765433330");
		  w.niNo("636");
		  w.postCode("2342342");
		  w.setEmail("mani@gmail.com");
		  w.nxtClick();
		  try {
				Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  w.setAcName("HDFC");
		  w.setAcNo("23123213");
		  w.setCode("345");
		  try {
				Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      w.SaveClick();
	      try {
				Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	      String expt[]= {"asrda","Eastbourn1","contractor","female","Ms","manujohn"};            
	      String uList[] = w.colmValues(); 	       
    	  Assert.assertEquals(uList, expt);  
	      
	       
	}
	
	@BeforeMethod
	public void beforeMethod() {
		  driver.get("https://www.qabible.in/payrollapp/");
	}
	@DataProvider
	  public Object[][] logintestdata() throws BiffException, IOException, InvalidFormatException { 
		  Object[][] data= ExcelData.getDataFromSheet("C:\\Users\\sazika\\Desktop\\Payroll.xlsx");
		  return data;
	  }

}
