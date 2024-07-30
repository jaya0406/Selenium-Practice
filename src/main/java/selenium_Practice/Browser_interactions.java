package selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Browser_interactions
{

	WebDriver driver = new ChromeDriver();
	
	public void BrowserInteractions()
	{
		//Browser Interaction
		String HomePage = "https://www.google.co.in/";
		
		driver.get(HomePage);//to launch browser
		//or driver.navigate().to(HomePage);
		
		driver.manage().window().maximize();//to maximize window
		
		String getCurrenturl = driver.getCurrentUrl();//to get current page url
		
		Assert.assertEquals(HomePage,getCurrenturl);//Verifying url
	}
	
	public void BrowserNavigation() throws InterruptedException
	{
		// Browser Navigation
		
		WebElement SearchBar = driver.findElement(By.className("gLFyf"));
		
		SearchBar.click();
		SearchBar.sendKeys("MakeMyTrip");
		
		Thread.sleep(1000);// to halt browser for a second
		
		WebElement RecentSearches = driver.findElement(By.className("wM6W7d"));
		
		//Basically, after sendkeys the specific website appears first. So, I used the class name which remains constant to locate element.
		System.out.println(RecentSearches.getText());
		
		//driver.navigate().to("https://www.makemytrip.com/");
		
		driver.navigate().back();// to navigate back

		driver.navigate().forward();//to navigate forward

		driver.navigate().refresh();//to refresh
			
	}
	
	public void PopUps() throws InterruptedException
	{
		driver.get("https://www.leafground.com/alert.xhtml");// website - useful for practicing automation commands
		driver.manage().window().maximize();
		
		//ALERT

		//simple alert- java script in built alert functionality, which opens a dialoug box that can be un-inspectable.
		WebElement SimpleAlert = driver.findElement(By.id("j_idt88:j_idt91"));
		SimpleAlert.click();
		driver.switchTo().alert().accept();	//used to click OK button in pop-up.
		WebElement GetSimpleAlertText = driver.findElement(By.id("simple_result"));
		System.out.println(GetSimpleAlertText.getText());// to confirm whether the button is clicked.
		
		//Confirm alert- similar to simple alert with cancel button.
		WebElement ConfirmAlert = driver.findElement(By.id("j_idt88:j_idt93"));
		ConfirmAlert.click();
		driver.switchTo().alert().dismiss();
		//I used .dismiss() method to click cancel button in alert, here you can also use .accept() method to click OK button in alert.
		WebElement GetConfirmAlertText = driver.findElement(By.id("result"));
		System.out.println(GetConfirmAlertText.getText());// to confirm whether the button is clicked.
		
		
		//Sweet Alert - Java script alert which is quit customise and enhanced alert which opens dialoug box that can be inspectable.
		//So no need to switch window to alert.
		WebElement SweetAlert = driver.findElement(By.name("j_idt88:j_idt95"));
		SweetAlert.click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt96_content")).getText());// to confirm whether the button is clicked.
		driver.findElement(By.id("j_idt88:j_idt98")).click();//-DismissSweetAlert
		
		//SweetModalDialoug
		Thread.sleep(1000);//to halt browser for a second
		WebElement SweetModalDialougAlert = driver.findElement(By.name("j_idt88:j_idt100"));
		SweetModalDialougAlert.click();
		System.out.println(driver.findElement(By.className("m-0")).getText());// to confirm whether the button is clicked.
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt101']//a[@aria-label='Close']")).click();//SweetModalDialougClose
		
		//PROMPT- Similar to Confirm alert, which includes a text box.
		WebElement AlertPrompt = driver.findElement(By.id("j_idt88:j_idt104"));
		AlertPrompt.click();
		driver.switchTo().alert().sendKeys("Alice");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("confirm_result")).getText());// to confirm whether the button is clicked.
		
		//Sweet Alert (Confirmation)
		WebElement SweetAlertConfirm = driver.findElement(By.id("j_idt88:j_idt106"));
		SweetAlertConfirm.click();
		System.out.println(driver.findElement(By.className("ui-confirm-dialog-message")).getText());
		driver.findElement(By.name("j_idt88:j_idt108")).click();
		//OR  driver.findElement(By.name("j_idt88:j_idt109")).click();- SweetAlertNo button
		//OR  driver.findElement(By.xpath("//*[@id='j_idt88:j_idt107']//a[@aria-label='Close']"));- SweetAlertClose button
	
		//Minimize and Maximize Sweet Alert -can be maximized and minimized but not a new window
		WebElement MinAndMaxSweetAlert = driver.findElement(By.name("j_idt88:j_idt111"));
		MinAndMaxSweetAlert.click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt112_content")).getText());
		WebElement MaxButton = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt112']//a[contains(@class,'maximize')]"));
		MaxButton.click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt112_content")).getAttribute("style"));
		Thread.sleep(1000);//to halt browser for a second
		MaxButton.click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt112_content")).getAttribute("style"));
		Thread.sleep(1000);//to halt browser for a second
		driver.findElement(By.xpath("//div[@id='j_idt88:j_idt112']//a[contains(@class,'close')]")).click();
	}
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		Browser_interactions bos = new Browser_interactions();
		//bos.BrowserInteractions();
		//bos.BrowserNavigation();
		bos.PopUps();

	}

}
