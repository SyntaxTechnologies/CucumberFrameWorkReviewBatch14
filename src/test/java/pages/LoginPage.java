package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath ="//*[@id='txtUsername']")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(xpath="//*[@id='btnLogin']")
    public WebElement loginButton;

    public LoginPage(){
    PageFactory.initElements(driver,this);
    }

}
