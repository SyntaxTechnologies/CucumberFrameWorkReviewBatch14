package steps;

import pages.loginPage;

public class pageInitializers {
    public static loginPage login;


    public static void initializePageObjects() {
        login = new loginPage();
    }


}
