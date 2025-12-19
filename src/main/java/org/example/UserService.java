package org.example;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserService {

    public static String baseURL = "https://qa-desk.stand.praktikum-services.ru";
    public static String userRegisterPath = "/api/signup";

    @Step("Создаю пользователя")
    public static UserRegister registerUser() {
        return registerUser(getNewRandomEmail(), getRandomPassword());
    }

    @Step("Создаю пользователя")
    public static UserRegister registerUser(String email, String password) {
        UserRegister user = new UserRegister(email, password);
        given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(userRegisterPath)
                .then()
                .statusCode(201);

        return user;
    }

    public static String getNewRandomEmail() {

        return UserUtils.getNewRandomEmail();
    }

    public static String getRandomPassword() {
        return UserUtils.getRandomPassword();
    }
}