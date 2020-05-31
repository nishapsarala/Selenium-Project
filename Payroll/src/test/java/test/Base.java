package test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;
	   
	  @BeforeClass
	  public void setup() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }

}
