package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class EditAdvertPage {

    private SelenideElement editAdvertButton = $x("//button[text()='Редактировать объявление']"); //Локатор для клика по кнопке редактирования карточки
    private SelenideElement saveChangesButton = $x("//button[@type='submit' and contains(normalize-space(), 'Сохранить изменения')]"); //Локатор для сохранения изменений

    public void clickEditAdvertButton() {
        editAdvertButton
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }

    public void setSaveChangesButton(){
        saveChangesButton
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
}


