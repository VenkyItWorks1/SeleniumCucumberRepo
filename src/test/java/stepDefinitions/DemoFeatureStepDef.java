package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoFeatureStepDef{

		WebDriver driver;

		@Before
		public void InitializeTest(Scenario scenario) {
			System.out.println("@Before method");
			//  scenarioDef = features.createNode(scenario.getName());
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
		}

		@After
		public void TearDownTest(Scenario scenario) {
			if (scenario.isFailed()) {
				//Take screenshot logic goes here
				System.out.println(scenario.getName());
			}
			System.out.println("Closing the browser : MOCK");
			driver.quit();
		}

		@BeforeStep
		public void BeforeEveryStep(Scenario scenario) {
			System.out.println("Before every step " + scenario.getId());
		}

		@AfterStep
		public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
			//System.out.println("Before every step " + stepTestStep.getId());
		}

		@Given("User is on Home page")
		public void userOnHomePage() {

			driver.get("https://opensource-demo.orangehrmlive.com/");
		}

		@When("User enters username as {string}")
		public void entersUsername(String userName) throws InterruptedException {

			System.out.println("Username Entered");
			driver.findElement(By.name("txtUsername")).sendKeys(userName);

		}

		@When("User enters password as {string}")
		public void entersPassword(String passWord) throws InterruptedException {

			System.out.println("Password Entered");
			driver.findElement(By.name("txtPassword")).sendKeys(passWord);

			driver.findElement(By.id("btnLogin")).submit();
		}

		@Then("User should be able to login sucessfully")
		public void sucessfullLogin() throws InterruptedException {

			String newPageText = driver.findElement(By.id("welcome")).getText();
			System.out.println("newPageText :" + newPageText);
			//assertThat(newPageText, containsString("Welcome"));

		}
		
	

	
	}
