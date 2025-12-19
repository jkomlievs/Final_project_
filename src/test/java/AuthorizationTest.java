import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest {

    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserService.baseURL;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserService.baseURL;
    }
    @DisplayName("Успешная авторизация")
    @Description("Авторизация ранее зарегистрированного пользователя")
    @Step("авторизация")
    @Test
    public void successfulAuthorizationTest(){
        AuthorizationPage authorizationPage = new AuthorizationPage();

        var user = UserService.registerUser();

        open("/");
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();

        authorizationPage.clickAvatar();
        authorizationPage.checkProfilePageIsVisible(); //добавила проверку, что пользователь авторизовался

        authorizationPage.clickLogoutButton();
    }
    @Step("Закрытие браузера")
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}

