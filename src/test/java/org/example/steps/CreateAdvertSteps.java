package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.MainPage;
import static com.codeborne.selenide.Selenide.open;

public class CreateAdvertSteps {

    private  CreateAdvertPage createAdvertPage = new CreateAdvertPage();
    private  MainPage mainPage = new MainPage();
    private  AuthorizationPage authorizationPage = new AuthorizationPage();

    private String advertName = "Morgan Super5";
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
    @And("the user delete the advert")
    public void userDeleteAdvert() {
        mainPage.clickAdvertCard();
        mainPage.clickDeleteCard();
    }

}
