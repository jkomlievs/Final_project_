package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DeleteAdvertPage {

    private final SelenideElement title = $x("//div[@class='description']//h2[text()='Mustang']");
    private final SelenideElement deleteButton = $x("//button[normalize-space()='Удалить']");


    public void clickTitleCard() {
        title
                .shouldBe(Condition.visible, Duration.ofSeconds(6))
                .click();
    }

    public void clickDeleteCard(){
        deleteButton
                .shouldBe(Condition.visible,Duration.ofSeconds(6))
                .click();
    }

    public boolean isAdvertNotPresent(String title) {
        return $$x("//h2[normalize-space()='" + title + "']").isEmpty();
    }
}