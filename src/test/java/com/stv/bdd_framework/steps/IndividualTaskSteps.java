package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import static com.stv.framework.core.lib.WigglePageURLs.*;
import com.stv.framework.core.utils.Waiters;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;


public class IndividualTaskSteps extends BasicFactoryTest {
    LoginPage loginPage = new LoginPage();

//Сценарий 1

    @Given("Main page is loaded")
    public void main_page_is_loaded(){
        getDriver().get(START_URL);
    } //заходим на главную страницу

    @When("user accepts cookie consent banner if the one appears and clicks on Your Account link")
    public void accept_cookies(){
        try {
            new MainFactoryPage().clickOnTrustButton();  // кликаем на принять куки (если они есть)
            Assert.assertTrue(new MainFactoryPage().getTrustButton().isDisplayed()); //проверяем, есть ли куки кнопка
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
      //вариант 1 - проверка по url
        //Thread.sleep(1000); //засыпаем, чтобы увидеть текущий url. без сна удасться получить только адрес https://www.wiggle.co.uk/
         Waiters.waitForElementVisible(getDriver(),2,loginPage.getLoginContainer()); //или можно использовать класс Waiters из пакета utils
         Assert.assertEquals(getDriver().getCurrentUrl(),START_URL_FOR_LOGIN_PAGE); // проверяем, зашли ли на нужную страницу
      //вариант 2 - проверка по вебэлементу
       // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //явное ожидание
       // Assert.assertTrue(loginPage.isLoginContainerDisplayed()); // проверяем, зашли ли на нужную страницу
    }

//Сценарий 2

    @When("user inputs {string} into password field")
    public void user_inputs_password(String string) throws InterruptedException {
        Thread.sleep(1000); //замедляем, чтобы увидеть работу кода в браузере
        loginPage.getPasswordField().sendKeys(string); //вводим через клавиатуру значения пароля из таблицы в сценарии аутлайн в поле ввода пароля
    }

    @And("user clicks on checkbox Show Password")
    public void user_clicks_on_show_password_to_enable() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.getShowPasswordCheckBox().click(); //кликаем на чекбокс "показать пароль"
}

    @And("checkbox is switched on")
    public void isCheckboxSwitchedOn() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(new LoginPage().getShowPasswordCheckBox().isEnabled()); //проверяем, включен ли чекбокс
    }

    @And("user clicks on checkbox to disable it")
    public void user_clicks_on_show_password_to_disable() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.getShowPasswordCheckBox().click(); //кликаем на чекбокс, чтобы его отключить
    }

    @And("user deletes input from password field")
    public void user_deletes_input_from_password_field() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.getPasswordField().sendKeys(Keys.COMMAND+"a");
        loginPage.getPasswordField().sendKeys(Keys.BACK_SPACE);
          // loginPage.getPasswordField().clear(); не подходит, т.к. после метода clear() не появляется валидационное сообщение, то есть необходимо удалять с клавиатуры
    }

    @Then("validation message for password field appears")
    public void validation_message_for_password_field_appears() throws InterruptedException {
        Thread.sleep(1000);
        String expectedErrorMessage = "Please enter your password";
        String actualMessage = loginPage.getValidationMessageForPasswordError().getText();
        Assert.assertEquals(actualMessage, expectedErrorMessage); //сравниваем актуальную и ожидаемую строки валидационного ссобщения
    }

    public void validation_message_for_email_address_appears() throws InterruptedException {
        Thread.sleep(1000);
        String expectedErrorMessage2 = "Please enter your email address";
        String actualMessage2 = loginPage.getValidationMessageForEmailError().getText();
        Assert.assertEquals(actualMessage2, expectedErrorMessage2); //сравниваем актуальную и ожидаемую строки валидационного ссобщения
    }
    //Сценарий 3

    @When("user clicks on Sign in securely button")
    public void user_clicks_on_sign_in_securely_button() {
        loginPage.getSignInSecurelyButton().click(); //кликаем на кнопку sign in securely
    }

    @Then("validation messages for email address field and password field appear")
    public void validation_messages_for_email_address_field_and_password_field_appear() throws InterruptedException {
        validation_message_for_password_field_appears();
        validation_message_for_email_address_appears();
    }

}
