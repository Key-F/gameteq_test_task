package com.keyf.gameteq_test_task.tests;

import com.keyf.gameteq_test_task.models.Entity;
import com.keyf.gameteq_test_task.models.Offer;
import com.keyf.gameteq_test_task.pages.AddPage;
import com.keyf.gameteq_test_task.pages.MainPage;
import com.keyf.gameteq_test_task.pages.OfferListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OffersListTest extends BaseTest{

    private MainPage mainPage;
    private AddPage addPage;
    private OfferListPage offerListPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(getDriver());
        offerListPage = new OfferListPage(getDriver());
        addPage = new AddPage(getDriver());
        mainPage.menuClick();
    }

    @Test
    @DisplayName("Check if new offer displays in offer list")
    public void newOfferInListTest() {
        Offer offer = new Offer();
        mainPage.openOffers();
        mainPage.addNewOffer();
        addPage.setOffer(offer);
        addPage.addNewEntity(Entity.OFFER);
        assertTrue(offerListPage.checkOfferIsPresent(offer), "offer is missing");
    }

    @Test
    @DisplayName("Deletion check in offer list")
    public void deleteOfferFromListTest() {
        Offer offer = new Offer();
        mainPage.openOffers();
        mainPage.addNewOffer();
        addPage.setOffer(offer);
        addPage.addNewEntity(Entity.OFFER);
        offerListPage.deleteOffer(offer);
        assertTrue(offerListPage.checkOfferIsDeleted(offer), "offer is still present");
    }

    @Test
    @DisplayName("Edit check in offer list")
    public void editOfferFromListTest() {
        Offer offer = new Offer();
        mainPage.openOffers();
        mainPage.addNewOffer();
        addPage.setOffer(offer);
        addPage.addNewEntity(Entity.OFFER);
        offerListPage.editOffer(offer);
        offer.setName(offer.getName() + "_edited");
        offer.setKey(offer.getKey() + "_edited");
        addPage.setName(offer.getName());
        addPage.setKey(offer.getKey());
        addPage.save();
        assertTrue(offerListPage.checkOfferIsPresent(offer), "offer hasn't changed");
    }
}
