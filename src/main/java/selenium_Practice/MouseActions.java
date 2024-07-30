package selenium_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public WebDriver driver= new ChromeDriver();
	public String LeafGround = "https://www.leafground.com/drag.xhtml";
	
	
	public void launchbrowser()
	{
		driver.get(LeafGround);
		driver.manage().window().maximize();
	}
	
	public void DragAndDrop(String col,String row) throws InterruptedException
	{
		launchbrowser();
		
		Actions a = new Actions(driver);
		
		//Draggable
		WebElement DragMeElement = driver.findElement(By.cssSelector("div[id='form:conpnl']"));
		
		a.clickAndHold(DragMeElement).moveByOffset(150, 0).release().perform();
		
		Thread.sleep(1000);
		
		//Droppable
		WebElement DragTo = driver.findElement(By.id("form:drag_content"));
		WebElement DragTarget = driver.findElement(By.id("form:drop"));
		
		System.out.println(driver.findElement(By.id("form:drop_content")).getText());// before dropping
		a.dragAndDrop(DragTo, DragTarget).perform();
		//OR  a.clickAndHold(DragTo).moveToElement(DragTarget).release().perform();
		System.out.println(driver.findElement(By.id("form:drop_content")).getText());// after dropping
		
		//Draggable column
		List<WebElement> getColumn = driver.findElements(By.xpath("//div[@id='form:j_idt94']//table[@role='grid']//th"));
		WebElement toColumn = driver.findElement(By.xpath("//div[@id='form:j_idt94']//table[@role='grid']//th[@id='form:j_idt94:j_idt99']"));
		for(WebElement eachgetColumn: getColumn )
		{
			String Gettext = eachgetColumn.getText();
			
			if(Gettext.equalsIgnoreCase(Gettext))
			{
				a.doubleClick(eachgetColumn).clickAndHold().moveToElement(toColumn).release().perform();
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.cssSelector("div[class='ui-growl-message']")).getText());
				break;
			}
		}
		Thread.sleep(10000);
		
		
		//Draggable Row
		List<WebElement> getRows = driver.findElements(By.xpath("//div[@id='form:j_idt111']//tbody//tr"));
		WebElement torow = driver.findElement(By.xpath("//div[@id='form:j_idt111']//tbody//tr[@data-ri='5']"));
		
		for(WebElement eachgetRows: getRows )
		{
			String Gettext = eachgetRows.findElement(By.tagName("td")).getText();
			
			if(Gettext.equalsIgnoreCase(row))
			{
				a.dragAndDrop(eachgetRows, torow);
				Thread.sleep(2000);
				//System.out.println(driver.findElement(By.xpath("//div[@role='alert']//p")).getText());
				break;
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		MouseActions ma = new MouseActions();
		ma.DragAndDrop("Name","Black Watch");
	}

}
