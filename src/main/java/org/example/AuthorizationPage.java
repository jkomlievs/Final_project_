package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    private final SelenideElement loginAndRegisterButton = $x("//button[normalize-space()='Вход и регистрация']");
    private final SelenideElement emailField = $x("//input[contains(@name,'email')]");
    private final SelenideElement passwordField = $x("//input[@type='password']");
    private final SelenideElement loginButton = $x("//button[contains(normalize-space(), 'Войти')]");
    private final SelenideElement logoutButton = $x("//button[normalize-space()='Выйти']");
    private final SelenideElement avatar = $("button.circleSmall");
    private final SelenideElement profileTitle = $("h1.h1.zeroMargin");

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

    public void clickAvatar() {
        avatar.shouldBe(visible).click();
    }
    public void checkProfilePageIsVisible() {
        profileTitle.shouldBe(visible);
    }

}