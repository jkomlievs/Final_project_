package org.example;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserMethods {

    public static String baseURL = "https://qa-desk.stand.praktikum-services.ru";
    public static final String LOGIN_1 = "mariatest13@yandex.ru";
    public static final String PASSWORD_1 = "12345678";
    public static final String SUBMIT_PASSWORD_1 = "12345678";

    public static String userLoginPath = "/api/signin";
    public static String userRegisterPath = "/api/signup";

    @Step("Создаю пользователя")
    public static Response registerUser(String email, String password, String submitPassword) {

        UserRegister user = new UserRegister(email, password, submitPassword);

        return given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(userRegisterPath)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Step("Логин пользователя")
    public static Response loginUser(UserLogin userLogin) {
        return given()
                .header("Content-type", "application/json")
                .body(userLogin)
                .when()
                .post(userLoginPath);
    }
    @Step ("Повторная регистрация")
    public static Response doubleRegister (String email, String password, String submitPassword){
    UserRegister user = new UserRegister("mariatest13@yandex.ru","12345678", "12345678");

        return given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(userRegisterPath)
                .then()
                .statusCode(400)
                .extract()
                .response();

    }
}