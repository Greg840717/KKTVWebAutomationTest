import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class UrlTest {

	@Test
	void test() throws Exception{
		repeatDiffeernetUrl("https://www.kktv.me");
		repeatDiffeernetUrl("https://kktv.me");
		repeatDiffeernetUrl("https://app.kktv.me");
	}
	
	void repeatDiffeernetUrl(String url) throws Exception{
		System.out.print("Test Url:" + url + "\n");
		System.setProperty("webdriver.chrome.driver","C:\\users\\greg\\chromedriver.exe");   
	    WebDriver browser = new ChromeDriver();
	    browser.manage().window().maximize();
	    browser.get(url);
	    browser.findElement(By.xpath("//a[@href='/login']")).click();
	    Thread.sleep(3000);
	    browser.findElement(By.linkText("KKBOX ±b¸¹")).click();
	    browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    browser.findElement(By.name("username")).sendKeys("gregcheng@kktv.me");
	    browser.findElement(By.name("password")).sendKeys("greg840812");
	    browser.findElement(By.xpath("//input[@class='btn btn-block btn-default btn-lg btn-primary btn-email']")).click();
	    Thread.sleep(5000);
	    Assert.assertTrue(browser.findElement(By.xpath("//img[@alt='logo']")).isDisplayed());
	    browser.close();
	}
}
