
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.example.AuthorizationPage;
import org.example.CreateAdvertPage;
import org.example.DeleteAdvertPage;
import org.example.MainPage;
import org.example.UserService;
import org.junit.jupiter.api .AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteTest {


    @BeforeEach
    public void setUp() {

        RestAssured.baseURI = UserService.baseURL;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = UserService.baseURL;
    }
    @Test
    @DisplayName("Удаление объявления")
    @Step("Проверка удаления своего объявления")
    public void deleteCartTest(){

        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        CreateAdvertPage createAdvertPage = new CreateAdvertPage();
        DeleteAdvertPage deleteAdvertPage = new DeleteAdvertPage();

        var user = UserService.registerUser();

        String title = "Mustang";

        open("/");
        authorizationPage.clickLoginAndRegisterButton();
        authorizationPage.enterEmail(user.getEmail());
        authorizationPage.enterPassword(user.getPassword());
        authorizationPage.clickLoginButton();

        createAdvertPage.clickCreateAdvert();
        createAdvertPage.uploadPhoto();
        createAdvertPage.setProductName("Mustang");
        createAdvertPage.selectCategory("Авто");
        createAdvertPage.selectNewCondition();
        createAdvertPage.selectCityMoscow();
        createAdvertPage.enterDescription("это авто");
        createAdvertPage.enterPrice("200");
        createAdvertPage.clickPublishButton();

        mainPage.search(title);
        mainPage.clickApplyButton();
        deleteAdvertPage.clickTitleCard();
        deleteAdvertPage.clickDeleteCard();

        mainPage.search(title); //поиск по карточке
        mainPage.clickApplyButton();
        assertTrue(                    // проверка что не отображается
                deleteAdvertPage.isAdvertNotPresent(title),
                "Объявление не должно отображаться в результатах поиска"
        );

        authorizationPage.clickLogoutButton();
    }
    @AfterEach
    public void closeBrowser() {

        Selenide.closeWebDriver();
    }
}