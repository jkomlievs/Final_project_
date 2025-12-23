package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AuthorizationPage;
import org.example.UserService;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @When("I open login form")
    public void openLoginForm() {

        var user = UserService.registerUser();
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() {
        var user = UserService.registerUser();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();
    }

    @Then("The user should be logged In")
    public void userShouldBeLoggedIn() { //проверка,что пользователь авторизовался
        authorizationPage.clickAvatar();
        authorizationPage.checkProfilePageIsVisible();
    }
}