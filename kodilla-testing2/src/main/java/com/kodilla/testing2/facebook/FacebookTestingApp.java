package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String REGISTER_BUTTON = "//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]";
    public static final String WAIT_FOR = "//div[@class=\"mbs _52lq fsl fwb fcb\"]";
    public static final String XPATH_DAY = "//select[@name=\"birthday_day\"]";
    public static final String XPATH_MONTH = "//select[@name=\"birthday_month\"]";
    public static final String XPATH_YEAR = "//select[@name=\"birthday_year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        try {
            WebElement registerButton = driver.findElement(By.xpath(REGISTER_BUTTON));
            registerButton.click();

            while (!driver.findElement(By.xpath(WAIT_FOR)).isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Redirecting to registration.");
        } finally {
            WebElement searchDay = driver.findElement(By.xpath(XPATH_DAY));
            Select selectDay = new Select(searchDay);
            selectDay.selectByIndex(8);

            WebElement searchMonth = driver.findElement(By.xpath(XPATH_MONTH));
            Select selectMonth = new Select(searchMonth);
            selectMonth.selectByValue("1");

            WebElement searchYear = driver.findElement(By.xpath(XPATH_YEAR));
            Select selectYear = new Select(searchYear);
            selectYear.selectByValue("1996");
        }
    }
}
