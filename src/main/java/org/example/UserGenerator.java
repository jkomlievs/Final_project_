package org.example;

public class UserGenerator {

        public static String DEFAULT_EMAIL = "mariatest13@yandex.ru";
        public static String DEFAULT_PASSWORD = "12345678";

        public static String getNewRandomEmail() {
            return Math.random() + DEFAULT_EMAIL;
        }
    }