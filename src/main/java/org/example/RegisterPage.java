package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    private  final SelenideElement loginAndRegisterButton = $x("//button[normalize-space()='Вход и регистрация']");
    private  final SelenideElement emailField = $x("//input[contains(@name,'email')]");
    private  final SelenideElement passwordField = $x("//input[@type='password']");
    private  final SelenideElement submitPasswordField = $x("//input[@name='submitPassword']");
    private  final SelenideElement registerButton = $x("//button[contains(text(),'Нет аккаунта')]");
    private  final SelenideElement createAccountButton = $x(".//button[text()='Создать аккаунт']");
    private  final SelenideElement userNameProfile = $x("//h3[contains(@class,'profileText') and contains(text(),'User')]");
    private  final SelenideElement errorMessage = $x("//span[contains(@class,'input_span') and text()='Ошибка']");
    private  final SelenideElement logoutButton = $x("//button[normalize-space()='Выйти']");


    public void setUserData(String email, String password, String submitPassword) {
        setEmailField(email);
        setPasswordField(password);
        setSubmitPasswordField(submitPassword);
    }

    public void setEmailField(String email) {

        emailField.setValue(email);
    }

    public void setPasswordField(String password) {

        passwordField.setValue(password);
    }

    public void setSubmitPasswordField(String submitPassword) {

        submitPasswordField.setValue(submitPassword);
    }

    public void clickLoginAndRegisterButton() {

        loginAndRegisterButton.shouldBe(visible).click();
    }

    public void clickRegisterButton() {

        registerButton.shouldBe(visible).click();
    }

    public void clickCreateAccountButton() {

        createAccountButton.shouldBe(visible).click();
    }

    public void checkUserNameVisible() {

        userNameProfile.shouldBe(visible).shouldHave(text("User."));
    }
    public void checkError() {

        errorMessage.shouldBe(visible).shouldHave(text("Ошибка"));
    }
    public void clickLogoutButton() {

        logoutButton.shouldBe(visible).click();
    }
}