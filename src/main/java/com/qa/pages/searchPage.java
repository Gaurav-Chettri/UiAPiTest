package com.qa.pages;

import com.qa.testbase.testBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage extends testBase {

    //****defining Object repository****

    @FindBy(name = "query")
    WebElement placeName;


    //****initialising elements****

    public searchPage(){
        PageFactory.initElements(driver, this);
    }

    //method for searching place

    public cityPage searchPlace(){
        placeName.sendKeys("Bangalore");
        placeName.sendKeys(Keys.ENTER);
        return new cityPage();
    }


}
