import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.MainPage;
import org.example.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class CreateAdvertTest {

    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserService.baseURL;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserService.baseURL;
    }

    @DisplayName("Создание объявления")
    @Description("Успешное создание объявления")
    @Step("создаем объявление")
    @Test
    public void successfulCreateAdvertTest() {

        CreateAdvertPage createAdvertPage = new CreateAdvertPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        MainPage mainPage = new MainPage();

        var user = UserService.registerUser();

        String advertName = "Morgan Super5";

        open("/");
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();

        createAdvertPage.clickCreateAdvert();
        createAdvertPage.uploadPhoto();
        createAdvertPage.setProductName(advertName);
        createAdvertPage.selectCategory("Авто");
        createAdvertPage.selectNewCondition();
        createAdvertPage.selectCityMoscow();
        createAdvertPage.enterDescription("автомобиль");
        createAdvertPage.enterPrice("200000000");
        createAdvertPage.clickPublishButton();

        open("/");
        mainPage.search(advertName);
        mainPage.clickApplyButton();
        mainPage.checkAdvertIsVisible(advertName);

        mainPage.clickAdvertCard();
        mainPage.clickDeleteCard();//сделала удаление, чтобы при прогонах не дублировались карточки и не вызывали баги

        authorizationPage.clickLogoutButton();

    }
    @Step("Закрываем браузер")
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}