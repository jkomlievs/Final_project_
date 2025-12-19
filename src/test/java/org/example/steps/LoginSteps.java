package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.AuthorizationPage;
import org.example.UserService;
import org.example.UserUtils;

public class LoginSteps {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("user is logged in")
    public void userIsLoggedIn() {
        var user = UserService.registerUser();
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();
    }
}