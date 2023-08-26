package com.keyf.gameteq_test_task.pages;

import com.keyf.gameteq_test_task.allure.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static com.keyf.gameteq_test_task.wait.MyWait.myWait;

public class MainPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    @FindBy(css = ".mat-slide-toggle-content")
    private WebElement toggleMenu;

    @FindBy(xpath = "//span[text()='Offers']")
    private WebElement offersButton;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardButton;

    @FindBy(xpath = "//span[contains(text(),'Add')]")
    private WebElement addButton;

    @FindBy(css = "mat-spinner[role='progressbar']")
    private WebElement progressSpinner;

    public void menuClick() {
        toggleMenu.click();
        LOG.info("menu was clicked");
    }

    public void openOffers() {
        offersButton.click();
        LOG.info("offers button was clicked");
    }

    public void openDashboard() {
        myWait(10).invisible(progressSpinner);
        dashboardButton.click();
        LOG.info("offers button was clicked");
    }

    public void addNewOffer() {
        addButton.click();
        LOG.info("add button was clicked");
    }
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
