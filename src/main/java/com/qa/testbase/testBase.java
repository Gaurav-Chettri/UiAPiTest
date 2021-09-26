package com.qa.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class testBase {

    public static WebDriver driver;
    public static Properties prop;

    public testBase() {
        try {
            prop = new Properties();
            FileInputStream fp = new FileInputStream(" ");
            prop.load(fp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialisation(){
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get("https://www.accuweather.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

}