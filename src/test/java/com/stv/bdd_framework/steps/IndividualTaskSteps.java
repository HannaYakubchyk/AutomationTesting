package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import static com.stv.framework.core.lib.WigglePageURLs.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class IndividualTaskSteps extends BasicFactoryTest {

//Сценарий 1

    @Given("Main page is loaded")
    public void main_page_is_loaded(){
        getDriver().get(START_URL);
    } //заходим на главную страницу

    @When("user accepts cookie consent banner if the one appears and clicks on Your Account link")
    public void accept_cookies(){
        try {
            new MainFactoryPage().clickOnTrustButton();  // кликаем на принять куки (если они есть)
        }
        catch (Exception e){
            System.out.println("Oops..  There was no right element to click on");
        }
        finally {
            new MainFactoryPage().clickOnAccountLink();//кликаем по ссылке Ваш Аккаунт
        }
    }

    @Then("Sign in page is loaded")
    public void sign_in_page_is_loaded() throws InterruptedException {
        Thread.sleep(1000); //засыпаем, чтобы увидеть текущий url. без сна удасться получить только адрес https://www.wiggle.co.uk/
        Assert.assertEquals(getDriver().getCurrentUrl(),START_URL_FOR_LOGIN_PAGE); // проверяем, зашли ли на нужную страницу
}

//Сценарий 2

    @When("user inputs {string} into password field")
        public void user_inputs_password(String string) throws InterruptedException {
            Thread.sleep(1000);
            getDriver().findElement(By.id("LogOnModel_Password")).sendKeys(string);
    }

    @And("user clicks on checkbox Show Password")
        public void user_clicks_on_show_password_to_enable() throws InterruptedException {
            Thread.sleep(1000);
            getDriver().findElement(By.id("passwordToggle")).click();
}

    @Then("checkbox is switched on")
        public void isCheckboxSwitchedOn() throws InterruptedException {
            Thread.sleep(1000);
            Assert.assertTrue(getDriver().findElement(By.id("passwordToggle")).isEnabled());
    }

    @When("user clicks on checkbox to disable it")
        public void user_clicks_on_show_password_to_disable() throws InterruptedException {
            Thread.sleep(1000);
        getDriver().findElement(By.id("passwordToggle")).click();
    }

    @And("user deletes input from password field")
        public void user_deletes_input_from_password_field() throws InterruptedException {
            Thread.sleep(1000);
        getDriver().findElement(By.id("LogOnModel_Password")).sendKeys(Keys.COMMAND+"a");
        getDriver().findElement(By.id("LogOnModel_Password")).sendKeys(Keys.BACK_SPACE);
       // getDriver().findElement(By.id("LogOnModel_Password")).clear(); не подходит, т.к. после метода clear() не появляется валидационное сообщение
    }


    @Then("validation message for password field appears")
    public void validation_message_for_password_field_appears() throws InterruptedException {
       Thread.sleep(1000);
        String expectedErrorMessage = "Please enter your password";
        WebElement w = getDriver().findElement(By.xpath("//*[@id=\"LogOnModel_Password-error\"]"));
        String actualMessage = w.getText();
       Assert.assertEquals(actualMessage, expectedErrorMessage);
    }

    //Сценарий 3

    @When("user clicks on Sign in securely button")
    public void user_clicks_on_sign_in_securely_button() {
        getDriver().findElement(By.id("qa-login")).click();
    }

    @Then("validation messages for email address field and password field appear")
    public void validation_messages_for_email_address_field_and_password_field_appear() throws InterruptedException {
        Thread.sleep(1000);
        String expectedErrorMessage = "Please enter your password";
        WebElement w1 = getDriver().findElement(By.xpath("//*[@id=\"LogOnModel_Password-error\"]"));
        String actualMessage = w1.getText();
        Assert.assertEquals(actualMessage, expectedErrorMessage);

        String expectedErrorMessage2 = "Please enter your email address";
        WebElement w2 = getDriver().findElement(By.id("LogOnModel_UserName-error"));
        String actualMessage2 = w2.getText();
        Assert.assertEquals(actualMessage2, expectedErrorMessage2);
    }

}
