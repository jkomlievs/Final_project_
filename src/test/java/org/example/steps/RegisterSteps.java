package org.example.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.RegisterPage;
import org.example.UserService;
import org.example.UserUtils;

public class RegisterSteps {

    private RegisterPage registerPage;
    private String email;
    private String password;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserService.baseURL;

        registerPage = new RegisterPage();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Given("the user is already registered via API")
    public void theUserIsAlreadyRegisteredViaApi() {
        var user = UserService.registerUser();
        email = user.getEmail();
        password = user.getPassword();
    }

    @When("the user opens the registration form")
    public void theUserOpensTheRegistrationForm() {
        registerPage.clickLoginAndRegisterButton();
        registerPage.clickRegisterButton();
    }

    @When("the user enters valid registration data")
    public void theUserEntersValidRegistrationData() {
        email = UserUtils.getNewRandomEmail();
        password = UserUtils.getRandomPassword();
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