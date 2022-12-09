package steps;

import io.cucumber.java.en.*;

public class loginSteps {

    @Given("User Navigates To the URL")
    public void user_navigates_to_the_url() {
        System.out.println("1");
    }
    @When("User Enters The correct UserName {string}")
    public void user_enters_the_correct_user_name(String username) {
        System.out.println(username);
    }
    @When("User Enters The correct Password {string}")
    public void user_enters_the_correct_password(String password) {
        System.out.println(password);
    }
    @When("user clicks On login button")
    public void user_clicks_on_login_button() {
        System.out.println("4");
    }
    @Then("user is logged in")
    public void user_is_logged_in() {
        System.out.println("5");
    }

}
