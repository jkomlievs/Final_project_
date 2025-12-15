package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @When("I open login form")
    public void openLoginForm() {
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() {
        authorizationPage.enterEmail("mariatest13@yandex.ru");
        authorizationPage.enterPassword("12345678");
        authorizationPage.clickLoginButton();
    }

    @Then("user should be logged in")
    public void userShouldBeLoggedIn() {

    }
}