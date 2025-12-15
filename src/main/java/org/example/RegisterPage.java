package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegisterPage {

    private  SelenideElement loginAndRegisterButton = $x("//button[normalize-space()='Вход и регистрация']");
    private  SelenideElement emailField = $x("//input[contains(@name,'email')]");
    private  SelenideElement passwordField = $x("//input[@type='password']");
    private  SelenideElement submitPasswordField = $x("//input[@name='submitPassword']");
    private  SelenideElement registerButton = $x("//button[contains(text(),'Нет аккаунта')]");
    private  SelenideElement createAccountButton = $x(".//button[text()='Создать аккаунт']");
    private  SelenideElement userNameProfile = $x("//h3[contains(@class,'profileText') and contains(text(),'User')]");
    private  SelenideElement errorMessage = $x("//span[contains(@class,'input_span') and text()='Ошибка']");
    private  SelenideElement logoutButton = $x("//button[normalize-space()='Выйти']");


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