package com.keyf.gameteq_test_task.tests;

import com.keyf.gameteq_test_task.models.Entity;
import com.keyf.gameteq_test_task.pages.AddPage;
import com.keyf.gameteq_test_task.pages.DashboardPage;
import com.keyf.gameteq_test_task.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashBoardTest extends BaseTest {

    private MainPage mainPage;
    private DashboardPage dashBoardPage;
    private AddPage addPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(getDriver());
        dashBoardPage = new DashboardPage(getDriver());
        addPage = new AddPage(getDriver());
        mainPage.menuClick();
    }

    @ParameterizedTest(name = "#{index} - Check for entity: \"{0}\"")
    @DisplayName("Check that entity count has changed correctly")
    @EnumSource(Entity.class)
    public void entityCountTest(Entity entityType) {
        int countBefore = dashBoardPage.getCount(entityType);
        mainPage.openOffers();
        mainPage.addNewOffer();
        addPage.addNewEntity(entityType);
        mainPage.openDashboard();
        assertEquals(countBefore + 1, dashBoardPage.getCount(entityType),
                "entity: " + entityType + " incrementation error");
    }

}
