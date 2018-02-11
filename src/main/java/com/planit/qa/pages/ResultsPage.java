package com.planit.qa.pages;

import com.planit.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="lst-ib")
    public WebElement searchBox;

    @FindBy(xpath="//h3[@class='r']")

    public WebElement firstLink;



}
