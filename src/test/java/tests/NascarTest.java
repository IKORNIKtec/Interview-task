package tests;

import model.nascar.NascarUserFactory;
import model.nascar.UserNascar;
import org.junit.Before;
import org.junit.Test;
import pages.nascar.NascarMainPage;

import static org.junit.Assert.assertTrue;

public class NascarTest extends BaseTest{
    UserNascar user = NascarUserFactory.getNewUser();
    NascarMainPage nascar;

    @Before
    public void setup(){
        nascar = new NascarMainPage(driver);
        nascar.open();
        nascar.registerUser(user);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void verifyUserLogout() {
        nascar.open();
        nascar.login(user);
        nascar.logout();
        assertTrue("User still loggedIn after Logout", nascar.isUserLoggedIn());
    }

}
