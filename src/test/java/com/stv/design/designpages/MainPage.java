package com.stv.design.designpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    private final By REGISTER_LINK_LOCATOR = By.id("wiggle-logo");

    public boolean isMainLogoDisplayed(){
        WebElement registerLink = getDriver().findElement(REGISTER_LINK_LOCATOR);
        return registerLink.isDisplayed();
    }

}
