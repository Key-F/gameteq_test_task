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
    private WebDriverWait wait;
    private int secondsToWait;


    public static MyWait myWait(int seconds) {
        return new MyWait(seconds);
    }

    public MyWait(int seconds) {
        secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public void pause() {
        try {
            LOG.info("waiting for: " + secondsToWait + " seconds");
            Thread.sleep(secondsToWait * 1000L);
        }
        catch (InterruptedException e){
            LOG.error("thread was interrupted");
        }
    }

    public void clickable(WebElement element) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes clickable: " + element.toString());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visible(WebElement element) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes visible: " + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibleBy(By locator) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes visible: " + locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void invisible(WebElement element) {
        LOG.info("Wait " + secondsToWait + " seconds, until element becomes invisible: " + element.toString());
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void textIsPresent(WebElement element, String text) {
        LOG.info("Wait " + secondsToWait + " seconds, until text is present: " + element.toString());
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}