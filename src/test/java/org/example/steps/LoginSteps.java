package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.AuthorizationPage;
import org.example.UserMethods;

public class LoginSteps {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("user is logged in")
    public void userIsLoggedIn() {
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
        authorizationPage.enterEmail(UserMethods.LOGIN_1);
        authorizationPage.enterPassword(UserMethods.PASSWORD_1);
        authorizationPage.clickLoginButton();
    }
}