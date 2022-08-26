package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utils.commonMethods;
import utils.configReader;

public class loginSteps extends commonMethods {


    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
     login.usernameTextField.sendKeys( configReader.getPropertyValue("username"));
     login.passwordTextField.sendKeys( configReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        login.loginButton.click();
    }
    @Then("admin user is successfully logged in and see the message {string}")
    public void admin_user_is_successfully_logged_in_and_see_the_message(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }
}
