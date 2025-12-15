package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AuthorizationPage {

    private SelenideElement loginAndRegisterButton = $x("//button[normalize-space()='Вход и регистрация']");
    private SelenideElement emailField = $x("//input[contains(@name,'email')]");
    private SelenideElement passwordField = $x("//input[@type='password']");
    private SelenideElement loginButton = $x("//button[contains(normalize-space(), 'Войти')]");
    private SelenideElement logoutButton = $x("//button[normalize-space()='Выйти']");

    public void setUserLoginData(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public void enterEmail(String email) {
        emailField.shouldBe(visible).setValue(email);
    }

    public void enterPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(Condition.enabled, Duration.ofSeconds(5)).click();
    }

    public void clickLoginAndRegisterButton() {
        loginAndRegisterButton.shouldBe(visible).click();
    }

    public void clickLogoutButton() {
        logoutButton.shouldBe(visible).click();
    }
}