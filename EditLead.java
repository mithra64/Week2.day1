package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		//filling the form
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABCD");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("user");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Miku");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("ECE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("week2 day1 assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mithraprabakaran17@gmail.com");
		
		//To select state from the drop down
		WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd = new Select(ele);
		dd.selectByValue("NY");
		driver.findElement(By.name("submitButton")).click();
		
		//To edit the details
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("createLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important notes");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.close();
	}

}
