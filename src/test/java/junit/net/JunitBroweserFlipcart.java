package junit.net;
import org.junit.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JunitBroweserFlipcart {
		
	 static long start;
	  static WebDriver flipcart;
 // static String search;
	static   String pname;
	static   String pname1 ;
//	static String productName;
//	static String productName2;
	  String dom = flipcart.getPageSource();
	  @BeforeClass 
	  public static void broweserLaunch()  {
		  
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\vetri\\eclipse-workspace\\JunitClass\\target\\msedgedriver.exe");
		  flipcart =new EdgeDriver();
		  flipcart.get("https://www.flipkart.com/");
		  flipcart.manage().window().maximize();
	  }
	  
	  @AfterClass
	  public static void browserQuit() {
   flipcart.quit();
		}
	  
	  @Before
	  public void starttime() {
		long  start = System.currentTimeMillis();
		 System.out.println("Before");
	  }
	  @After
	  public void endtime() {
	      long end = System.currentTimeMillis();
	      System.out.println("After = " + (end - start));
	  }
	   
	@Test
	public void method1() {	
	 // WebElement login;
	
		WebElement search=flipcart.findElement(By.name("q"));
        search.sendKeys("iphone15");
        search.submit();
       WebElement iphone1= flipcart.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]"));
       iphone1.click();
	}
	@Test
	public void method2() {	
		
		WebElement productName = flipcart.findElement(By.xpath("(//div[@class='KzDlHZ'])[2]"));
		productName.getText();
		String pname = productName.getText();
	    System.out.println("Method 2 = " + pname);
	}
		 
	@Test
	public void method3() {	//span[@class='VU-ZEz']
		
		String parentwindow=flipcart.getWindowHandle();
		Set<String> childWindow = flipcart.getWindowHandles();
		for(String ip:childWindow) {
			if(! parentwindow.equals(ip))
			flipcart.switchTo().window(ip);
		}	
		WebElement productName2 = flipcart.findElement(By.xpath("//span[@class='VU-ZEz']"));
		productName2.getText();
		String pname1 = productName2.getText();
	    System.out.println("Method 3 = " + pname1);
		
	}
	@Test
	public void method4() {	
		
		if(pname!=null && pname1!=null && pname.equals(pname1)) 
		{
			System.out.println("method 4 = both product names are same");
		}
		else {
			System.out.println("method 4 = both product names are not same");
		}	
	}
	@Test
	public void method5() throws AWTException {	
		 WebElement buynow= flipcart.findElement(By.xpath("//button[@type='button']"));
		 buynow.click();
	     
		 Robot rb=new Robot();
 		 rb.keyPress(KeyEvent.VK_ENTER);
 		 rb.keyRelease(KeyEvent.VK_ENTER);
         flipcart.findElement(By.xpath("//input[@class='r4vIwl Jr-g+f']")). sendKeys("9342912125"); 
         rb.keyPress(KeyEvent.VK_ENTER);
 		 rb.keyRelease(KeyEvent.VK_ENTER);
 		 
	//     WebElement login = flipcart.findElement(By.xpath("//input[@class='r4vIwl Jr-g+f']"));
	  //   login.sendKeys("9342912125");
	}
}
