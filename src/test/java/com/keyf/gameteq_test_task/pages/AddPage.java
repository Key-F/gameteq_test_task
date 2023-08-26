package com.keyf.gameteq_test_task.pages;

import com.keyf.gameteq_test_task.allure.AllureLogger;
import com.keyf.gameteq_test_task.models.Entity;
import com.keyf.gameteq_test_task.models.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.keyf.gameteq_test_task.utils.NameGenerator.generateEntityName;

public class AddPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AddPage.class));


    private WebDriver driver;
    @FindBy(css = "input[name='name']")
    private WebElement nameField;

    @FindBy(css = "input[name='key']")
    private WebElement keyField;

    @FindBy(css = "select[name='category']")
    private WebElement categoryField;

    @FindBy(css = "mat-select[name='networks']")
    private WebElement networksField;

    @FindBy(css = "mat-select[name='group']")
    private WebElement groupField;

    @FindBy(xpath = "//div[div[*[@name='category']]]//button")
    private WebElement addCategoryButton;

    @FindBy(xpath = "//div[div[*[@name='networks']]]//button")
    private WebElement addNetworkButton;

    @FindBy(xpath = "//div[div[*[@name='group']]]//button")
    private WebElement addGroupButton;

    @FindBy(css = ".cdk-overlay-pane input[id^='mat-input']")
    private WebElement newEntityName;

    @FindBy(xpath = "//span[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy(xpath = "//*[contains(text(), 'Add segment')]")
    private WebElement addSegmentButton;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    private WebElement saveButton;

    @FindBy(css = "[class = 'mat-option mat-option-multiple ng-star-inserted'][role ='option']")
    private List<WebElement> networkOptions;

    @FindBy(css = "[class = 'mat-option ng-star-inserted'][role ='option']")
    private List<WebElement> groupOptions;

    public void addNewEntity(Entity entity) {
        if (entity.equals(Entity.OFFER)) {
            createNewOffer();
            return;
        }
        By addButton;
        String entityType = entity.getAddPageLabel();
        if (entity.equals(Entity.SEGMENT)) {
            addButton = By.xpath("//*[contains(text(), 'Segments')]/button");
        } else
            addButton = By.xpath("//div[div[*[@name='" + entityType + "']]]//button");
        driver.findElement(addButton).click();
        String entityName = generateEntityName(entityType);
        LOG.info(entityType + " name is: " + entityName);
        newEntityName.sendKeys(entityName);
        createButton.click();
    }

    public void createNewOffer() {
        Offer offer = new Offer();
        nameField.sendKeys(offer.getName());
        keyField.sendKeys(offer.getKey());
        networksField.click();
        networkOptions.get(0).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
        groupField.click();
        groupOptions.get(0).click();
        addSegmentButton.click();
        saveButton.click();
        LOG.info("New offer with name: \"" + offer.getName() + "\" was created");
    }

    public AddPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
