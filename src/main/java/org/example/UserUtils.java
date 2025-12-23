package org.example;

import java.util.UUID;

public class UserUtils {

        public static String getNewRandomEmail() {
            return UUID.randomUUID() + "@yandex.ru";
        }

        public static String getRandomPassword() {
            return UUID.randomUUID().toString();
        }
    }