package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author ASUS
 *
 */
public class BrowserFactory 
{

	static WebDriver driver;
	
	public static WebDriver StartBrowser(String Browsername)
	{
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\SoftwareTesting\\selinium jar\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		
		return driver;
	}
}
