package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.AuthorizationPage;
import org.example.UserService;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("the main page is opened")
    public void openMainPage() {

        open("/");
    }

    @Then("user logs out")
    public void userLogsOut() {

        authorizationPage.clickLogoutButton();
    }
}