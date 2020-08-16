package dev.patel.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.patel.pages.WikiHomePage;
import dev.patel.runners.WikiRunner;
import junit.framework.Assert;

public class WikiLangSteps {
	
	public static WikiHomePage homepage = WikiRunner.homepage;
	public static WebDriver driver = WikiRunner.driver;
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------
	


	@Given("^The Guest is on the login page$")
	public void The_Guest_is_on_the_login_page() throws Throwable {
	    
		driver.get("http://localhost:4200/login");
		
	}
	
	@When("^The Guest types username$")
	public void The_Guest_types_username() throws Throwable {
	
		WebElement un = driver.findElement(By.name("uname"));
		un.sendKeys("jayun");
	}
	@When("^The Guest types password$")
	public void The_Guest_types_password() throws Throwable {

		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("jaypw");
	}
	@When("^The Guest clicks employee radio button$")
	public void The_Guest_clicks_employee_radio_button() throws Throwable {
	
		WebElement radio = driver.findElement(By.name("dayOfTheWeek"));
		radio.click();
	}
	@When("^The Guest clicks log in button$") 
	public void The_Guest_clicks_log_in_button() throws Throwable {
	
		WebElement log = driver.findElement(By.name("submit"));
		log.click();
		//log.thread.sleep();
		//WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.name("submit"))).click();

		
		driver.get("http://localhost:4200/employee");
	}
	
//----------------------------------------------------------------------------------------------------------------------
	@When("^The Guest types amount$")
	public void The_Guest_types_amount() throws Throwable {
	
		WebElement un = driver.findElement(By.name("amount"));
		un.sendKeys("5100");
	}
	
	@When("^The Guest types status$")
	public void The_Guest_types_status() throws Throwable {
		WebElement un = driver.findElement(By.name("status"));
		un.sendKeys("pending");
	}
	
	@When("^The Guest types note$")
	public void The_Guest_types_note() throws Throwable {
		WebElement un = driver.findElement(By.name("note"));
		un.sendKeys("Great");
	}
	@When("^The Guest clicks create reimburstment button$")
	public void The_Guest_clicks_create_reimburstment_button() throws Throwable {
	
		WebElement log = driver.findElement(By.name("REM"));
		log.click();
	}
	@Then("^The Guest should be on employee page$")
	public void The_Guest_should_be_on_employee_page() throws Throwable {
		driver.get("http://localhost:4200/e");
		// Assert.assertEquals("Employee Page", driver.getTitle());
	}
	
	
//	@Then("^Reimburstment should be created$")
	//public void Reimburstment_should_be_created() throws Throwable {
		
		// Assert.assertEquals("Employee Page", driver.getTitle());
//}
//----------------------------------------------------------------------------------------------------------------------
//2
	/*
	@Given("^The Guest is on the login page1$")
	public void The_Guest_is_on_the_login_page1() throws Throwable {
	    
		driver.get("http://localhost:4200/login");
		
	}
	@When("^The Guest types username1$")
	public void The_Guest_types_username1() throws Throwable {
		WebElement un = driver.findElement(By.name("uname"));
		un.sendKeys("jaymanun");
	}
	@When("^The Guest types password1$")
	public void The_Guest_types_password1() throws Throwable {

		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("jaymanpw");
	}
	@When("^The Guest clicks employee radio button1$")
	public void The_Guest_clicks_employee_radio_button1() throws Throwable {
	
		WebElement radio = driver.findElement(By.id("Manager"));
		radio.click();
	}
	@When("^The Guest clicks log in button1$")
	public void The_Guest_clicks_log_in_button1() throws Throwable {
	
		WebElement log = driver.findElement(By.name("submit"));
		log.click();
		
	
		//driver.get("http://localhost:4200/employee");
	}
	@When("^The Guest clicks approve button$")
	public void The_Guest_clicks_approve_button() throws Throwable {
	
		WebElement log = driver.findElement(By.name("submit"));
		log.click();
		
	
		//driver.get("http://localhost:4200/employee");
	}
	@When("^The Guest clicks ok button$")
	public void The_Guest_clicks_ok_button() throws Throwable {
	
		WebElement log = driver.findElement(By.name("submit"));
		log.sendKeys("jaymanpw");
		
	
		//driver.get("http://localhost:4200/employee");
	}
	
*/	



}
