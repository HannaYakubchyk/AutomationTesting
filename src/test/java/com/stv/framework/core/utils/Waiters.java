package com.stv.framework.core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waiters {

    public static void waitForElementVisible(WebDriver driver, int timeout, WebElement webElement) {
        new WebDriverWait(driver, timeout).pollingEvery(Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
