package com.planit.qa.pages;

import com.planit.qa.base.BasePage;
import static com.planit.qa.base.CommonFunctions.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="lst-ib")
    public WebElement searchBox;

    @FindBy(xpath="//input[value='Google Search']")
    public WebElement searchButton;

    public ResultsPage navigateToResultsPage() {

        waitForEelementToBeVisible(driver, searchBox);
        searchBox.sendKeys(Keys.ENTER);
        return new ResultsPage(driver);
    }
}
