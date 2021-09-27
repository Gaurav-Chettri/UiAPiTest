package com.qa.pages;

import com.qa.testbase.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cityPage extends testBase {

    //****defining Object repository****

    @FindBy(css = "span.text")
    WebElement currentWeather;

    public cityPage() {
        PageFactory.initElements(driver, this);
    }

    public cityTempPage selectingCurrentWeather() {

        //*****to avoid stale element exception*****

        boolean staleElement = true;
        while (staleElement) {
            try {
                driver.findElement(By.cssSelector("span.text")).click();
                staleElement = false;

            } catch (StaleElementReferenceException | NoSuchElementException e) {
                staleElement = true;
            }

        }
        return new cityTempPage();
    }

}
