package com.keyf.gameteq_test_task.pages;

import com.keyf.gameteq_test_task.allure.AllureLogger;
import com.keyf.gameteq_test_task.models.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static com.keyf.gameteq_test_task.wait.MyWait.myWait;

public class OfferListPage {

    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(OfferListPage.class));

    @FindBy(xpath = "//span[contains(text(),'yes!')]")
    private WebElement confirmButton;

    String dynamicXpathTemplate = "//tr[td[contains(text(), '%s') " +
            "and contains(@class, 'cdk-column-name')] and " +
            "td[contains(text(), '%s') " +
            "and contains(@class, 'cdk-column-key')]]";
    By deleteButton = By.xpath(".//span[contains(text(), 'Delete')]");
    By editButton = By.xpath(".//span[contains(text(), 'Edit')]");

    public boolean checkOfferIsPresent(Offer offer) {
        String xpath = String.format(dynamicXpathTemplate, offer.getName(), offer.getKey());
        By offerRow = By.xpath(xpath);
        return driver.findElement(offerRow).isDisplayed();
    }

    public boolean checkOfferIsDeleted(Offer offer) {
        String xpath = String.format(dynamicXpathTemplate, offer.getName(), offer.getKey());
        By offerRow = By.xpath(xpath);
        myWait(3).invisible(offerRow);
        return driver.findElements(offerRow).isEmpty();
    }

    public void deleteOffer(Offer offer) {
        String xpath = String.format(dynamicXpathTemplate, offer.getName(), offer.getKey());
        By offerRow = By.xpath(xpath);
        driver.findElement(offerRow)
                .findElement(deleteButton)
                .click();
        confirmButton.click();
        LOG.info(offer.getName() + " delete clicked");
    }

    public void editOffer(Offer offer) {
        String xpath = String.format(dynamicXpathTemplate, offer.getName(), offer.getKey());
        By offerRow = By.xpath(xpath);
        driver.findElement(offerRow)
                .findElement(editButton)
                .click();
        LOG.info(offer.getName() + " edit clicked");
    }

    public OfferListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
