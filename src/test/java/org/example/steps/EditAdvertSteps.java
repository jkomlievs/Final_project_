package org.example.steps;

import io.cucumber.java.en.*;
import org.example.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditAdvertSteps {

    private final CreateAdvertPage createAdvertPage = new CreateAdvertPage();
    private final EditAdvertPage editAdvertPage = new EditAdvertPage();
    private final MainPage mainPage = new MainPage();

    private final String advertName = "Morgan";
    String expectedPrice = "200 000 001 ₽";
    String newPrice = "200000001";

    @Given("user creates a new advert with price {string}")
    public void userCreatesNewAdvert(String price) {
        createAdvertPage.clickCreateAdvert();
        createAdvertPage.uploadPhoto();
        createAdvertPage.setProductName(advertName);
        createAdvertPage.selectCategory("Авто");
        createAdvertPage.selectNewCondition();
        createAdvertPage.selectCityMoscow();
        createAdvertPage.enterDescription("автомобиль");
        createAdvertPage.enterPrice(price);
        createAdvertPage.clickPublishButton();
    }

    @When("user opens the advert card")
    public void userOpensAdvertCard() {
        mainPage.search(advertName);
        mainPage.clickApplyButton();
        mainPage.clickAdvertCard();
        editAdvertPage.clickEditAdvertButton();
    }

    @When("user edits the advert price to {string}")
    public void userEditsAdvertPrice(String newPrice) {
        expectedPrice = "200 000 001 ₽";
        createAdvertPage.enterPrice(newPrice);
        editAdvertPage.setSaveChangesButton();
    }

    @Then("updated advert price should be visible")
    public void updatedAdvertPriceShouldBeVisible() {
        open("/");
        mainPage.search(advertName);
        mainPage.clickApplyButton();
        mainPage.checkPriceVisible();
        assertEquals(expectedPrice, mainPage.getAdvertPrice());
    }
}