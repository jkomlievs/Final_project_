package org.example.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.RegisterPage;
import org.example.UserGenerator;
import org.example.UserMethods;

public class RegisterSteps {

    private RegisterPage registerPage;
    private String email;
    private String password;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserMethods.baseURL;

        registerPage = new RegisterPage();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Given("the user is already registered via API")
    public void theUserIsAlreadyRegisteredViaApi() {
        email = UserMethods.LOGIN_1;
        password = UserMethods.PASSWORD_1;
        UserMethods.doubleRegister(email, password, password);
    }

    @When("the user opens the registration form")
    public void theUserOpensTheRegistrationForm() {
        registerPage.clickLoginAndRegisterButton();
        registerPage.clickRegisterButton();
    }

    @When("the user enters valid registration data")
    public void theUserEntersValidRegistrationData() {
        email = UserGenerator.getNewRandomEmail();
        password = UserGenerator.DEFAULT_PASSWORD;
        registerPage.setUserData(email, password, password);
    }

    @When("the user enters existing registration data")
    public void theUserEntersExistingRegistrationData() {
        registerPage.setUserData(email, password, password);
    }

    @When("the user clicks the create account button")
    public void theUserClicksTheCreateAccountButton() {
        registerPage.clickCreateAccountButton();
    }

    @Then("the user is successfully registered")
    public void theUserIsSuccessfullyRegistered() {
        registerPage.checkUserNameVisible();
    }

    @Then("the registration error message is displayed")
    public void theRegistrationErrorMessageIsDisplayed() {
        registerPage.checkError();
    }
}