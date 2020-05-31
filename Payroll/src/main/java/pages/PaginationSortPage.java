package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationSortPage {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	@FindBy(xpath="//a[contains(text(),'Workers')]")
	WebElement workerLink;
	
	@FindBy(xpath="//ul[@class='pagination']//li//a")
	private List<WebElement> pageNxtLink;
	
	@FindBy(xpath="//ul[@class='pagination']//li[@class='next']//a")
	WebElement pageNextLink;
		
	@FindBy(xpath="//ul[@class='pagination']//li[@class='prev']//a")
	WebElement pagePrevLink;
	
	
	public PaginationSortPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickWorkerLink() {
		workerLink.click();
	}
	public void pageNumAllNextClk() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//int s=pageNxtLink.size();
		//for(int i=0; i<s-2; i++)
		//{ 
		while(pageNextLink.isEnabled()) {
		//	String nextxpath="//ul[@class='pagination']//li[@class='next']//a";
			//String lstxpath="//ul[@class='pagination']//li[@class='next disabled']//span";
			// WebDriverWait wait = new WebDriverWait(driver,60);
			
			// WebElement paginatebutton=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nextxpath))); 
			 
			 try {
				Thread.sleep(2000);
			 } catch (InterruptedException e) { 
				e.printStackTrace();
			 }	
			 js.executeScript("window.scrollTo(0,1000)");
			 
		   if(pageNextLink.isDisplayed() && pageNextLink.isEnabled())
		   {
			   pageNextLink.click();
		   }else {
			   break;
		   }
		} 
		while(pagePrevLink.isEnabled()) {
			String nextxpath="//ul[@class='pagination']//li[@class='prev']//a";
			  WebDriverWait wait = new WebDriverWait(driver,60);
			 WebElement paginatebutton=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nextxpath)));
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			 js.executeScript("window.scrollTo(0,1000)");
			 
		   if(paginatebutton.isEnabled())
		   {
			   paginatebutton.click();
		   }
		} 
		   
		//}

		 
	}
	

}
