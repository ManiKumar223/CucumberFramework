package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDef {

    public WebDriver driver;
    public LoginPage loginPage;
    public AddNewCustomerPage addNewCustomerPage;
    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        addNewCustomerPage = new AddNewCustomerPage(driver);
        }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {

        driver.get(url);
    }

        @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String emailadd, String password) {

        loginPage.enterEmail(emailadd);
        loginPage.enterPassword(password);
        }

        @When("Click on Login")
    public void click_on_login() {

        loginPage.clickOnLoginButton();
        }

        @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {

        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

     }

     @When("User click on Log out link")
    public void user_click_on_log_out_link() {

        loginPage.clickOnLogOutButton();
        }

        @Then("close browser")
    public void close_browser() {

        driver.close();
    }

    @Then("User can view Dashboad")
    public void user_can_view_dashboad() {

        String actualTitle = addNewCustomerPage.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";

        if (actualTitle.equals(expectedTitle))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {

        addNewCustomerPage.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {

        addNewCustomerPage.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {

        addNewCustomerPage.clickOnAddnew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        String actualTile = addNewCustomerPage.getPageTitle();
        String expectedTitle = "Customers / nopCommerce administration";

        if (actualTile.equals(expectedTitle))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        addNewCustomerPage.enterEmail("testmani@gmail.com");
        addNewCustomerPage.enterPassword("Loffy123");
        addNewCustomerPage.enterFirstName("mani");
        addNewCustomerPage.enterLastName("poluboina");
        addNewCustomerPage.enterGender("male");
        addNewCustomerPage.enterCompanyName("Cts");
        addNewCustomerPage.enterDob("10/06/1990");
        addNewCustomerPage.enterAdminContent("Admin content");
        addNewCustomerPage.enterManagerOfVendor("Vendor 1");

    }

    @When("click on Save button")
    public void click_on_save_button() {

        addNewCustomerPage.clickOnSave();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedConfirmation) {

        String bodyTagText = driver.findElement(By.tagName("Body")).getText();
        if (bodyTagText.contains(expectedConfirmation))
        {
            Assert.assertTrue(true);
        }

        else
        {
            Assert.assertTrue(false);
        }

    }

}
