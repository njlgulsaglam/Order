package com.order;

	import java.util.Random;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	
	    public class Order {
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver" ,
					"/Users/nejlagulsaglam/Documents/selenium dependencies/drivers/chromedriver");
				
				WebDriver driver = new ChromeDriver();
	         // driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		Thread.sleep(2000);
		
		Random r = new Random();
		int q = r.nextInt(100)+1;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(""+q);
		
		int mnl = r.nextInt();
		int a =97;
		int z =122;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mnl; i++) {
			int randomLetterNum = r.nextInt(z-a+1)+a;
			sb.append((char)randomLetterNum);
		}
		String middeleName =sb.toString();
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("John " +middeleName+ "Smith");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		Thread.sleep(2000);
		
		int zip =r.nextInt(100000 -10000)+10000;
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(""+zip);
		Thread.sleep(2000);
		
		int temp = r.nextInt(3)+1;
		if(temp==1) {
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		StringBuilder cardNumber = new StringBuilder("4");
		for (int i = 0; i < 15; i++) {
			cardNumber.append(r.nextInt(10));
		}
		driver.findElement(By.id("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber.toString());

		}else if(temp==2) {
		
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			StringBuilder cardNumber = new StringBuilder("5");
			for (int i = 0; i < 15; i++) {
				cardNumber.append(r.nextInt(10));
			}
			driver.findElement(By.id("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber.toString());

		}else if (temp==3) {
			
		}
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
		StringBuilder cardNumber = new StringBuilder("3");
		for (int i = 0; i < 14; i++) {
			cardNumber.append(r.nextInt(10));
		}
		driver.findElement(By.id("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber.toString());


		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber.toString());
		
		int m = r.nextInt(12)+1;
		String month = ""+m;
		if(m<10) {
			month =0 +month;
		}
		int y =r.nextInt(100);
		String year = ""+y;
		if(y<20) {
			year = 0+year;
		}
	
		
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(month+"/"+year);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		String expected = "New order has been successfully added." ;
		String actual = driver.getPageSource();
		if(actual.contains(expected)) {
			System.out.println("PASSED !!!");
		}else {
			System.out.println("FAILED !!!");
		System.out.println("expected:\t" +expected);
		System.out.println("Actual:\t" +actual);
		
		
		}
		
		}
		
	
	}
