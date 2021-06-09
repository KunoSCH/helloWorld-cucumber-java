package bindings;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefinitions {
    WebDriver driver = null;
    @Given("^The browser is open$")
    public void the_browser_is_open() throws Throwable {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^The user is on the homepage$")
    public void the_user_is_on_the_homepage() throws Throwable {
        driver.navigate().to("http://localhost:8080/hello-world/");
    }

    @Then("^The page should display \"([^\"]*)\"$")
    public void the_page_should_display(String headerText) throws Throwable {
        String expectedOutput = headerText;
        String actual = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedOutput, actual);
    }

    @After
    public void closeBrowser(Scenario scenario){
        driver.close();
        driver.quit();
    }
}
