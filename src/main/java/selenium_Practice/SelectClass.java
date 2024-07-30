package selenium_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectClass {
	
	public WebDriver driver= new ChromeDriver();
	public String LeafGround = "https://www.leafground.com/select.xhtml";
	public String ChooseCourse[] = {"Jmeter","RestAssured","AWS","Appium","Playwright"};
	public String unSelectCourse[] = {"RestAssured","Jmeter"};
	public WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	
	public void launchbrowser()
	{
		driver.get(LeafGround);
		driver.manage().window().maximize();
	}
	
	
	// Select Drop down
	public void SelectDropDown(String UIAutomation_tool) throws Exception
	{	
		WebElement Selecttool = driver.findElement(By.className("ui-selectonemenu"));
		Selecttool.click();
		Select Dropdwn = new Select(Selecttool);//
		
		System.out.println(Dropdwn.isMultiple());//verifying whether it is single select or multiple select
		
		List<WebElement> getdrop = Dropdwn.getOptions();//get drop down elements into the list
		
		for(WebElement eachgetdrop: getdrop )
		{
			String getmatch = eachgetdrop.getText();
			if(getmatch.equalsIgnoreCase(UIAutomation_tool))
			{
				Dropdwn.selectByVisibleText(getmatch);
				System.out.println("My Favorite UI Automation tool is "+ getmatch+".");
			}
		}
		
		Thread.sleep(2000);
	}
	
	// Custom drop down
	public void ListDropdown() throws InterruptedException
	{
	
	
		//Select Multiple Dropdown - ul tag
		System.out.println("I Chose :");
		for(int i =0; i<ChooseCourse.length; i++)
		{
			String course = ChooseCourse[i];
			
			WebElement click= driver.findElement(By.xpath("//button[starts-with (@class,'ui-autocomplete-dropdown')]"));
			wait.until(ExpectedConditions.elementToBeClickable(click));
			click.click();
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@id='j_idt87:auto-complete_panel']//ul//li[last()]"))));
			List<WebElement> getMultipleDropdwn = driver.findElements(By.xpath("//span[@id='j_idt87:auto-complete_panel']//li"));
			
			for(WebElement eachelement :getMultipleDropdwn)
			{
				wait.until(ExpectedConditions.visibilityOf(eachelement));
				String getmultiDropDwnText = eachelement.getText();

				if(course.equalsIgnoreCase(getmultiDropDwnText))
				{
					wait.until(ExpectedConditions.elementToBeClickable(eachelement));
					eachelement.click();
					System.out.print(eachelement.getText()+" ");
					break;
				}
			}
		}
		
		//Deselect multiple dropdown
		System.out.println("\nI UnSelect: ");
		for(int j=0; j<unSelectCourse.length; j++)
		{
			String unselect = unSelectCourse[j];
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[starts-with(@class,'ui-autocomplete-multiple-container')]//li[last()]")));
			
			List<WebElement> UnSelect = driver.findElements(By.xpath("//ul[starts-with(@class,'ui-autocomplete-multiple-container')]//li"));
			for(WebElement eachUnselect : UnSelect)
			{
				String getUnselect = eachUnselect.getText();
				
				if(unselect.equalsIgnoreCase(getUnselect))
				{
					wait.until(ExpectedConditions.elementToBeClickable(eachUnselect.findElement(By.cssSelector("span[class$='ui-icon-close']"))));
					eachUnselect.findElement(By.cssSelector("span[class$='ui-icon-close']")).click();
					System.out.print(getUnselect+" ");
					break;
				}
			}
		}
	}
	
	
	public void IsSelectedCountry(String Country,String City) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='j_idt87:country']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='j_idt87:country_panel']//li[last()]"))));
		
		List<WebElement>getcountries = driver.findElements(By.xpath("//div[@id='j_idt87:country_panel']//li"));
		
		for(WebElement eachgetcountries: getcountries)
		{
			String country = eachgetcountries.getText();
			if(Country.equalsIgnoreCase(country))
			{
				wait.until(ExpectedConditions.elementToBeClickable(eachgetcountries)).click();
				System.out.println("Country I chose "+country);
				break;
			}
		}
		
		
		if(driver.findElement(By.cssSelector("div[class='col-12']")).getText()!="Select Country")
		{
			Thread.sleep(1000);
			driver.findElement(By.id("j_idt87:city")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//ul[@id='j_idt87:city_items']//li[last()]"))));
			
			List<WebElement> getCity = driver.findElements(By.xpath("//div//ul[@id='j_idt87:city_items']//li"));
			
			for( WebElement eachgetCity: getCity)
			{
				if(City.equalsIgnoreCase(eachgetCity.getText()))
				{
					wait.until(ExpectedConditions.elementToBeClickable(eachgetCity)).click();
					System.out.println("City I chose "+eachgetCity.getText());
					break;
				}
			}
			
		}
		else
		{
			System.out.println("Kindly select country to choose City.");
			return;
		}
		
	}
	
	public void IsSelectedLanguage(String Language,String Two) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='j_idt87:lang']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//ul[@id='j_idt87:lang_items']//li[last()]"))));
		
		List<WebElement>getLanguages = driver.findElements(By.xpath("//div//ul[@id='j_idt87:lang_items']//li"));
		
		for(WebElement eachgetLanguages: getLanguages)
		{
			String Lang = eachgetLanguages.getText();
			if(Language.equalsIgnoreCase(Lang))
			{
				wait.until(ExpectedConditions.elementToBeClickable(eachgetLanguages)).click();
				System.out.println("Language I chose "+Lang);
				break;
			}
		}
		
		
		if(driver.findElement(By.cssSelector("div[class='col-12']")).getText()!="Select Language")
		{
			Thread.sleep(1000);
			driver.findElement(By.id("j_idt87:value")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//ul[@id='j_idt87:value_items']//li[last()]"))));
			
			List<WebElement> Gettwo = driver.findElements(By.xpath("//div//ul[@id='j_idt87:value_items']//li"));
			
			for( WebElement eachGettwo: Gettwo)
			{
				if(Two.equalsIgnoreCase(eachGettwo.getText()))
				{
					wait.until(ExpectedConditions.elementToBeClickable(eachGettwo)).click();
					System.out.println("Number I chose "+eachGettwo.getText());
					break;
				}
			}
			
		}
		else
		{
			System.out.println("Kindly select Language to choose number.");
			return;
		}
		
	}
	public void dropdown() throws Exception
	{
		launchbrowser();
		SelectDropDown("Cypress");
		ListDropdown();
		IsSelectedCountry("INDIA","Chennai");
		IsSelectedLanguage("English","Two");
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		SelectClass sc = new SelectClass();
		sc.dropdown();
	}

}
