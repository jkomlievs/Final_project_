import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.EditAdvertPage;
import org.example.MainPage;
import org.example.UserMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class EditAdvertTest {

    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserMethods.baseURL;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserMethods.baseURL;
    }

    @DisplayName("Редактирование объявления")
    @Description("Успешное редактирование своего объявления")
    @Step("Редактируем свое объявление")
    @Test
    public void editAdvertAndCheckPriceTest() {

        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        CreateAdvertPage createAdvertPage = new CreateAdvertPage();
        EditAdvertPage editAdvertPage = new EditAdvertPage();

        String email = UserMethods.LOGIN_1;
        String password = UserMethods.PASSWORD_1;
        String advertName = "Morgan";
        String expectedPrice = "200 000 001 ₽";

        open("/");
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.clickLoginButton();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(password);
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

        mainPage.search(advertName);
        mainPage.clickApplyButton();
        mainPage.clickAdvertCard();
        editAdvertPage.clickEditAdvertButton();

        createAdvertPage.enterPrice("200000001");
        editAdvertPage.setSaveChangesButton();

        open("/");
        mainPage.search(advertName);
        mainPage.clickApplyButton();

        mainPage.checkPriceVisible();
        String actualPrice = mainPage.getAdvertPrice();

        Assertions.assertEquals(
                expectedPrice,
                actualPrice,
                "Цена объявления не обновилась после редактирования"
        );

        mainPage.clickAdvertCard();
        mainPage.clickDeleteCard();
        authorizationPage.clickLogoutButton();
    }

    @Step("Закрываем браузер")
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}