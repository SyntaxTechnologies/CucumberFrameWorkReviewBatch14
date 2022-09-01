package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeInformationPage;
import pages.loginPage;

public class pageInitializers {
    public static loginPage login;
    public static DashboardPage dash;
    public static EmployeeInformationPage emp;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects() {

        login = new loginPage();
        dash = new DashboardPage();
        emp = new EmployeeInformationPage();
        addEmployeePage = new AddEmployeePage();
    }


}



//where should we initalize the page intializers   (call method initalize page objects())