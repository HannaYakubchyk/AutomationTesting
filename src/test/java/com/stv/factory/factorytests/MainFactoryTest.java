package com.stv.factory.factorytests;

import com.google.common.base.Verify;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.stv.framework.core.lib.WigglePageURLs.*;
import java.net.http.HttpClient;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();

    @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertEquals(actualResult, true, "Account link isn't visible");
    }

//почему этот тест не срабатывает с первого раза? если убрать зависимость, то работает
    @Test (description = "Assert the login page is loaded", dependsOnMethods = {"assertAccountIconIsDisplayed"})
    public void assertLoginPageOpened() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
    }

    //my test
    @Test(description = "Assert new customer is registered")
    public void assertNewCustomerIsRegistered() {

        getDriver().get(START_URL_FOR_LOGIN_PAGE);
        loginPage.registerNewCustomer();
        Assert.assertEquals(new RegistrationPage().isRegistrationContainerDisplayed(), true, "Registration page isn't loaded properly");
    }



}
