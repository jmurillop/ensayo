package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interactions.TakeAndSave;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageExample;

import java.io.IOException;

public class SiteExampleStepsDefinitions {
    String path = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\webDriver\\chromedriver.exe";
    WebDriver driver;
    //Se definen las páginas que van a pasar por el test.
    PageExample pageExample;

    String name="Eustaquio";
    TakeAndSave takeAndSave;

    @Given("Eustaquio gets in the example site page")
    public void eustaquioGetsInTheExampleSitePage() throws IOException {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Register.html");
        takeAndSave=new TakeAndSave();
        takeAndSave.screenshot(driver,"1. gets in the example site page");
    }

    @When("Eustaquio does whatever he wants")
    public void eustaquioDoesWhateverHeWants() throws IOException {
        pageExample = new PageExample(driver);
        pageExample.setTEXTBOX_FIRSTNAME(name);
        takeAndSave.screenshot(driver,"2. setTEXTBOX_FIRSTNAME");
        pageExample.setCHECKBOX_CRICKET();
        takeAndSave.screenshot(driver,"3. setCHECKBOX_CRICKET");
        pageExample.setLIST_SKILLS();
        takeAndSave.screenshot(driver,"4. setLIST_SKILLS");
    }

    @Then("Eustaquio is very happy")
    public void eustaquioIsVeryHappy() {
        pageExample.validateTEXTBOX_FIRSTNAME(name);
        pageExample.validateCHECKBOX_CRICKET();
        pageExample.validateLIST_SKILLS();
    }

    @After
    public void quit() {
        driver.quit();
    }

}
