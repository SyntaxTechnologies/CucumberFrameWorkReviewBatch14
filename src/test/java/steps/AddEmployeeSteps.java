package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ExcelReader;
import utils.commonMethods;
import utils.constants;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends commonMethods {

    @When("then user click on pim Option")
    public void then_user_click_on_pim_option() {
        click(dash.pimOption);
    }

    @When("user clicks on AddEmployee option")
    public void user_clicks_on_add_employee_option() {
        click(dash.addEmployeeOption);
    }

    @When("user enter {string} , {string} and {string} and click on save btn then verify the employee is added")
    public void user_enter_and_and_click_on_save_btn_then_verify_the_employee_is_added(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstName, fname);
        sendText(addEmployeePage.middleName, mname);
        sendText(addEmployeePage.lastName, lname);

//        click on save
        click(addEmployeePage.saveButton);
//        getting hte first and last name
        String actualFistname = addEmployeePage.addedEmployeefirstName.getAttribute("value");
        String actualLname = addEmployeePage.addedEmployeelastName.getAttribute("value");

//        Assertion
        Assert.assertEquals(actualFistname, fname);
        Assert.assertEquals(actualLname, lname);
    }

    // another method
    @When("user enter {string} , {string} and {string}")
    public void user_enter_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstName, fname);
        sendText(addEmployeePage.middleName, mname);
        sendText(addEmployeePage.lastName, lname);
    }

    @When("click on save btn")
    public void click_on_save_btn() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee is added with {string} , {string} and {string}")
    public void employee_is_added_with_and(String fname, String mname, String lname) {
        //        getting hte first and last name

        String actualFistname = addEmployeePage.addedEmployeefirstName.getAttribute("value");
        String actualLname = addEmployeePage.addedEmployeelastName.getAttribute("value");

//        Assertion
        Assert.assertEquals(actualFistname, fname);
        Assert.assertEquals(actualLname, lname);
    }


//    dataTbale

    @When("user adds the information of different employees and save them")
    public void user_adds_the_information_of_different_employees_and_save_them(DataTable dataTable) {

        //to  get the data from feature file in the form of list of maps
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp :
                employeeNames) {
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");

            //it will enter fresh values after each iteration
            sendText(addEmployeePage.firstName, firstNameValue);
            sendText(addEmployeePage.middleName, middleNameValue);
            sendText(addEmployeePage.lastName, lastNameValue);

            click(addEmployeePage.saveButton);
            click(dash.addEmployeeOption);

        }

    }


    @When("user adds multiple employees from excel file using {string} sheet and verify the employee has added")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_employee_has_added(String sheetName) throws InterruptedException {

        List<Map<String, String>> employeesInfo = ExcelReader.excelListIntoMap(constants.TEST_DATA_FILEPATH, sheetName);


        Iterator<Map<String, String>> itr = employeesInfo.iterator();

        while(itr.hasNext()){

            Map<String, String> employee = itr.next();
            String fname = employee.get("firstName");
            String mname = employee.get("middleName");
            String lnmae=employee.get("lastName");
            String  uname=employee.get("username");
            String pswrd=employee.get("password");
            String cpasword=employee.get("confirmPassword");







        }





    }

}
