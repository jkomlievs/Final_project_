import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.RegisterPage;
import org.example.UserGenerator;
import org.example.UserMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class RegisterTest {

    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserMethods.baseURL;

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserMethods.baseURL;

    }
    @DisplayName("Успешная регистрация")
    @Description("Пользователь может успешно зарегистрироваться")
    @Step("регистрация")
    @Test
    public void successfulRegistrationTest() {

        String email = UserGenerator.getNewRandomEmail();
        String password = UserGenerator.DEFAULT_PASSWORD;

        RegisterPage registerPage = new RegisterPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        open("/");

        registerPage.clickLoginAndRegisterButton();
        registerPage.clickRegisterButton();
        registerPage.setUserData(email, password, password);
        registerPage.clickCreateAccountButton();
        registerPage.checkUserNameVisible();
        registerPage.clickLogoutButton();
        authorizationPage.clickLogoutButton();
    }
    @DisplayName("Неуспешная регистрация")
    @Description("Пользователь не может зарегистрироваться повторно")
    @Step("регистрация зарегистрированного пользователя")
    @Test
    public void duplicateRegistrationShouldFailTest() {
        String email = "mariatest13@yandex.ru";
        String password = "12345678";

        UserMethods.doubleRegister(email, password, password);

        RegisterPage registerPage = new RegisterPage();

        open("/");

        registerPage.clickLoginAndRegisterButton();
        registerPage.clickRegisterButton();
        registerPage.setUserData(email, password, password);
        registerPage.clickCreateAccountButton();
        registerPage.checkError();
    }
    @Step("Закрытие браузера")
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}
