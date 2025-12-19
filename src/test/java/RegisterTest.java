import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.RegisterPage;
import org.example.UserService;
import org.example.UserUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class RegisterTest {

    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserService.baseURL;

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserService.baseURL;

    }


    @DisplayName("Успешная регистрация")
    @Description("Пользователь может успешно зарегистрироваться")
    @Step("регистрация")
    @Test
    public void successfulRegistrationTest() {

        String email = UserUtils.getNewRandomEmail();
        String password = UserUtils.getRandomPassword();

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
        var user = UserService.registerUser();

        RegisterPage registerPage = new RegisterPage();
        open("/");
        registerPage.clickLoginAndRegisterButton();
        registerPage.clickRegisterButton();
        registerPage.setUserData(user.getEmail(), user.getPassword(), user.getPassword());
        registerPage.clickCreateAccountButton();
        registerPage.checkError();
    }

    @Step("Закрытие браузера")
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}
