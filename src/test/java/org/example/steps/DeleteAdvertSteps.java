package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.DeleteAdvertPage;
import org.example.MainPage;
import org.example.UserService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteAdvertSteps {

    private final CreateAdvertPage createAdvertPage = new CreateAdvertPage();
    private final DeleteAdvertPage deleteAdvertPage = new DeleteAdvertPage();
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    String title = "Mustang";

    @Given("the user is logged in")
    public void userLogIn() {
        var user = UserService.registerUser();

        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();
    }

    @Given("the user has created an advert with title {string}")
    public void theUserHasCreatedAnAdvertWithTitle(String title) {

        createAdvertPage.clickCreateAdvert();
        createAdvertPage.uploadPhoto();
        createAdvertPage.setProductName(title);
        createAdvertPage.selectCategory("Авто");
        createAdvertPage.selectNewCondition();
        createAdvertPage.selectCityMoscow();
        createAdvertPage.enterDescription("test car");
        createAdvertPage.enterPrice("200");
        createAdvertPage.clickPublishButton();
    }

    @When("the user searches for advert {string}")
    public void theUserSearchesForAdvert(String title) {
        mainPage.search(title);
        mainPage.clickApplyButton();
    }

    @When("the user opens the advert card")
    public void theUserOpensTheAdvertCard() {

        deleteAdvertPage.clickTitleCard();
    }

    @When("the user deletes the advert")
    public void theUserDeletesTheAdvert() {

        deleteAdvertPage.clickDeleteCard();
    }

    @Then("the advert {string} should not be found in search results")
    public void theAdvertShouldNotBeFoundInSearchResults(String title) {
        mainPage.search(title);
        mainPage.clickApplyButton();
        assertTrue(
                deleteAdvertPage.isAdvertNotPresent(title),
                "Объявление не должно отображаться в результатах поиска"
        );
    }
    @And("the user logs out")
    public void theUserLogout(){
        authorizationPage.clickLogoutButton();
    }
}