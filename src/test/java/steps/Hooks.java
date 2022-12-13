package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void PreCondition(){
        openBrowserAndLaunchApplication();
    }
    @After
    public void PostCondition(){
        closeBrowser();
    }
}
