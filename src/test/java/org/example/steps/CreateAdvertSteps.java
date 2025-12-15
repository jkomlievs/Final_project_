package org.example.steps;

import io.cucumber.java.en.*;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAdvertSteps {

    private  CreateAdvertPage createAdvertPage = new CreateAdvertPage();
    private  MainPage mainPage = new MainPage();
    private  AuthorizationPage authorizationPage = new AuthorizationPage();

    private String advertName = "Morgan";
    private String description = "автомобиль";
    private String price = "200000000";

    @When("user creates a new advert")
    public void userCreatesNewAdvert() {
        createAdvertPage.clickCreateAdvert();
        createAdvertPage.uploadPhoto();
    }

    @When("user fills advert data")
    public void userFillsAdvertData() {
        createAdvertPage.setProductName(advertName);
        createAdvertPage.selectCategory("Авто");
        createAdvertPage.selectNewCondition();
        createAdvertPage.selectCityMoscow();
        createAdvertPage.enterDescription(description);
        createAdvertPage.enterPrice(price);
    }

    @When("user publishes the advert")
    public void userPublishesAdvert() {
        createAdvertPage.clickPublishButton();
    }

    @Then("advert should be visible in search results")
    public void advertShouldBeVisibleInSearchResults() {
        open("/");
        mainPage.search(advertName);
        mainPage.clickApplyButton();
        mainPage.checkAdvertIsVisible(advertName);
    }

    @Then("user deletes the advert")
    public void userDeletesAdvert() {
        mainPage.clickAdvertCard();
        mainPage.clickDeleteCard();
        assertTrue(mainPage.isCardDeleted(advertName), "Карточка должна быть удалена");
        authorizationPage.clickLogoutButton();
    }

    @Then("advert should be removed")
    public void advertShouldBeRemoved() {
        assertTrue(mainPage.isCardDeleted(advertName));
    }
}
