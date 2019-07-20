import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;

class SampleTest {
	
	String Test_url = "https://www.kktv.me";
	@Test
	void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\users\\greg\\chromedriver.exe");   
	       WebDriver browser = new ChromeDriver();
	       browser.manage().window().maximize();
	       browser.get(Test_url);       
	       WebElement href = browser.findElement(By.xpath("//a[@href='/featured']"));
	      assertTrue((href.isDisplayed()));  
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      browser.findElement(By.xpath("//a[@href='/login']")).click();
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      Thread.sleep(5000);
	      browser.findElement(By.linkText("KKBOX 帳號")).click();
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      browser.findElement(By.name("username")).sendKeys("gregcheng@kktv.me");
	      browser.findElement(By.name("password")).sendKeys("greg840812");
	      browser.findElement(By.xpath("//input[@class='btn btn-block btn-default btn-lg btn-primary btn-email']")).click();
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      browser.findElement(By.xpath("//span[@class='navbar__icon-group']")).click();
	      String Account_Text = browser.findElement(By.xpath("//a[@href='/account']")).getText();
	      System.out.print("\r\n" + Account_Text);
	      assertEquals("帳號資訊", Account_Text);
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      browser.findElement(By.xpath("//a[@href='/account']")).click();
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      String Account = browser.findElement(By.xpath("//ul[@class='info__content']/li[1]")).getText();
	      System.out.print(Account);
	      assertEquals("gregcheng@kktv.me", Account);
	      Thread.sleep(3000);
	      browser.navigate().back();
	      Thread.sleep(5000);
	      String Title_url = browser.findElement(By.xpath("//div[@class='kanban-item target']/a")).getAttribute("href");
	      System.out.print("\r\nHeadline Url : "+Title_url);
	      browser.findElement(By.xpath("//div[@class='kanban-item target']")).click();
	      Thread.sleep(5000);
	      String detailTitle_url = browser.getCurrentUrl();
	      System.out.print("\r\nDetail Url : "+detailTitle_url);
	      assertEquals(Title_url, detailTitle_url);
	      browser.navigate().back();
	      Thread.sleep(5000);
	      browser.findElement(By.xpath("//div[@class='collapsible-field collapsible-field--left']")).click();
	      browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      Thread.sleep(3000);
	      browser.findElement(By.xpath("//input")).sendKeys("新垣結衣");
	      Thread.sleep(1000);
	      browser.findElement(By.xpath("//input")).sendKeys(Keys.RETURN);
	      Thread.sleep(5000);
	      //	       browser.get("https://www.saucelabs.com");       
//	       WebElement href = browser.findElement(By.xpath("//a[@href='/beta/login']"));
//	      assertTrue((href.isDisplayed()));  
	      browser.close();
	}

}
