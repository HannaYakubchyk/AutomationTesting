package com.stv.factory.factorypages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {


    @FindBy(className = "bem-checkout__login-container")
    private WebElement loginContainer;

    @FindBy(id = "DualRegisterEmailModel_Email")
    private WebElement newCustomerEmailInput;

    @FindBy(id = "qa-dual-register")
    private WebElement newCustomerContinueButton;

    @FindBy(id="LogOnModel_Password")
    private WebElement passwordField;

    @FindBy(id="passwordToggle")
    private WebElement showPasswordCheckBox;

    @FindBy(xpath = "//*[@id=\"LogOnModel_Password-error\"]")
    private WebElement validationMessageForPasswordError;

    @FindBy(id = "LogOnModel_UserName-error")
    private WebElement validationMessageForEmailError;

    @FindBy(id = "qa-login")
    private WebElement signInSecurelyButton;

    public void clickOnContinueButton(){
        newCustomerContinueButton.click();
    }

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public void registerNewCustomer(){
        newCustomerEmailInput.click();
       // newCustomerEmailInput.sendKeys("test@test.by" + Keys.ENTER);   // альтернативно можно перейти и при нажатии Enter
        newCustomerEmailInput.sendKeys("test@test.by");
        newCustomerContinueButton.click();

    }
    public WebElement getLoginContainer() {
        return loginContainer;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getShowPasswordCheckBox() {
        return showPasswordCheckBox;
    }

    public WebElement getValidationMessageForPasswordError() {
        return validationMessageForPasswordError;
    }

    public WebElement getValidationMessageForEmailError() {
        return validationMessageForEmailError;
    }

    public WebElement getSignInSecurelyButton() {
        return signInSecurelyButton;
    }
}