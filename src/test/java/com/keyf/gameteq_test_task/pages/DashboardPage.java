package com.keyf.gameteq_test_task.pages;

import com.keyf.gameteq_test_task.allure.AllureLogger;
import com.keyf.gameteq_test_task.models.Entity;
import com.keyf.gameteq_test_task.wait.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class DashboardPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DashboardPage.class));

    WebDriver driver;
    @FindBy(css = "mat-spinner[role='progressbar']")
    private WebElement progressSpinner;

    public int getCount(Entity entity) {
        String entityName = entity.getDashboardLabel();
        MyWait.myWait(5).invisible(progressSpinner);
        String countText = driver.findElement(By.xpath("//mat-card-title[text()='" + entityName + "']/following-sibling::node()")).getText();
        String numberOnly = countText.replaceAll("[^0-9]", "");
        LOG.info("Entity count for: " + entityName + " is: " + numberOnly);
        return Integer.parseInt(numberOnly);

    }

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
