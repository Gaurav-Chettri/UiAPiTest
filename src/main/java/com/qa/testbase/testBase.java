package com.qa.testbase;

import org.openqa.selenium.WebDriver;

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
}