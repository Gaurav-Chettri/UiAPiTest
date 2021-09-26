package com.qa.pages;

import com.qa.testbase.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cityTempPage extends testBase {

    @FindBy(css = "div.display-temp")
    WebElement temperature;

    public cityTempPage(){
        PageFactory.initElements(driver, this);
    }

    public void fetchingTemperature(){

        WebElement temperature = driver.findElement(By.cssSelector("div.display-temp"));

        String temp = temperature.getText();
        System.out.println(temp);

    }

}
