package com.keyf.gameteq_test_task.wait;

import com.keyf.gameteq_test_task.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class MyWait {
    private final Logger LOG = LoggerFactory.getLogger(MyWait.class);
    private final WebDriverWait wait;
    private final int secondsToWait;

    public static MyWait myWait(int seconds) {
        return new MyWait(seconds);
    }

    public MyWait(int seconds) {
        secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public void invisible(WebElement element) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes invisible: " + element.toString());
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void invisible(By locator) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes invisible: " + locator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}