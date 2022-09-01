package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.commonMethods;

public class AddEmployeePage extends commonMethods {

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="middleName")
    public WebElement middleName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement checkBox;

    @FindBy(id="user_name")
    public WebElement usernameEmployee;

    @FindBy(id="user_password")
    public WebElement passwordEmployee;

    @FindBy(id="re_password")
    public WebElement confirmPasswordEmployee;

    @FindBy(id="employeeId")
    public WebElement empIdLoc;

    @FindBy(id="personal_txtEmpFirstName")
    public  WebElement addedEmployeefirstName;

    @FindBy(id="personal_txtEmpLastName")
    public  WebElement addedEmployeelastName;


    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
