package com.stv.bdd_framework.steps;

import com.stv.design.designtests.BasicTest;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPageSteps extends BasicTest {


    @Given("Sign in and Sign up page is loaded")
    public void sign_in_and_sign_up_page_is_loaded()  {
        getDriver().get("https://www.wiggle.co.uk/secure/myaccount/logon?returnUrl=%2Fsecure%2Faccount");
    }

    @When("user enters valid email into Email address field and clicks Continue button")
    public void registerNewCustomer() {
       new LoginPage().registerNewCustomer();
    }


    @Then("new Customer account creation page is loaded")
    public void accountCreationPageIsOpened(){
        new RegistrationPage().isRegistrationContainerDisplayed();
    }
}
