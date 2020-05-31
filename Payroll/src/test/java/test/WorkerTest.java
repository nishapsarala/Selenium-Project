package test;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pages.LoginPage;
import pages.WorkerCreatePage;
import pages.WorkerPage;
import utility.ExcelData;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class WorkerTest extends Base{
	 @Test(dataProvider = "logintestdata")
  public void WorkerDetails(String username,String password) throws AWTException {
	  
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
	 	  
	  WorkerPage wp= new WorkerPage(driver);
	  wp.setfname("mani");
	  wp.SearchClick();
	  
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  wp.ViewClick();
	  try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  w.clickWorkerLink();
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	  
	  wp.setfname("mani");wp.SearchClick();
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  wp.EditClick();
	  
	 
	  w.title();
	  w.gender();
	  w.branch();
	  w.setfname("manukira");
	  w.division();
	  w.setlname("sss");
	  w.setDob("28-04-2020");
	  w.empType();
	  w.setaddress("MRE 1/1, Veena, TVM");
	  w.paySlip();
	  w.phone("99999999");
	  w.niNo("636");
	  w.postCode("2342342");
	  w.setEmail("mm@gmail.com");
	  w.nxtClick();
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  w.setAcName("CANARA");
	  w.setAcNo("232323");
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
      String expt[]= {"asrda","Eastbourn1","contractor","female","Ms","manukira"};            
      String uList[] = w.colmValues(); 	       
	  Assert.assertEquals(uList, expt);  
      
	  
	  w.clickWorkerLink();
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  wp.setfname("mani");wp.SearchClick();
	  try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  wp.DeleteClick(); 
	  driver.switchTo().alert().accept();
	   
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
