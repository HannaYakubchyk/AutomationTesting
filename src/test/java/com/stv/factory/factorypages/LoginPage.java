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
}
