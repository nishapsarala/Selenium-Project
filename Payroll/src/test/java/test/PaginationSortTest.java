package test;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pages.LoginPage;
import pages.PaginationSortPage;
import utility.ExcelData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert; 

public class PaginationSortTest  extends Base{
  @Test(dataProvider = "logintestdata")
  public void verifyPageinationSort(String username,String password) {
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
	  
	  PaginationSortPage p=new PaginationSortPage(driver);
	  p.clickWorkerLink();
	  try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
       
	  p.pageNumAllNextClk();
	 // p.pageNumAllPrevClk();
  
       
	 // p.pageNextLinkClk();  
      
	   
	 // p.pagePrevLinkClk();
  }
  @BeforeMethod
	public void beforeMethod() {
		  driver.get("https://www.qabible.in/payrollapp/");
	}

  @DataProvider
  public Object[][] logintestdata() throws BiffException, IOException, InvalidFormatException { 
	  Object[][] data= ExcelData.getDataFromSheet("C:\\Users\\sazika\\Desktop\\Payroll2.xlsx");
	  return data;
  }


}
