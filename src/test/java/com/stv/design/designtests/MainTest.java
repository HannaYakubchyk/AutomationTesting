package com.stv.design.designtests;

import com.stv.design.designpages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BasicTest {

    @Test(description = "Assert the main page is loaded and the main logo is visible")
    public void assertWiggleIconIsDisplayed() {
        Assert.assertEquals(new MainPage().isMainLogoDisplayed(), true, "The main page isn't loaded properly");
    }
}
