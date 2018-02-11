package com.planit.qa.testCases;

import com.planit.qa.baseTest.BaseTest;
import com.planit.qa.pages.HomePage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homeTests() {

        homePage = new HomePage(driver);
        homePage.searchBox.sendKeys("planit australia");
        homePage.searchBox.sendKeys(Keys.ENTER);
    }

    @Test
    public void homeTestseeeee() {

        homePage = new HomePage(driver);
        homePage.searchBox.sendKeys("planit australia");
        resultsPage =  homePage.navigateToResultsPage();

        resultsPage.firstLink.click();

    }
}
