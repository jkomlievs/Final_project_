package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EditAdvertPage {

    private final SelenideElement editAdvertButton = $x("//button[text()='Редактировать объявление']");
    private final SelenideElement saveChangesButton = $x("//button[@type='submit' and contains(normalize-space(), 'Сохранить изменения')]");

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