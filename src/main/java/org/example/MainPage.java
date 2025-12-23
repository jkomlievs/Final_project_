package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement advertCard =   $x("//div[contains(@class,'card')]//h2[contains(text(),'Morgan Super5')]");
    private final SelenideElement searchInput = $x("//input[@type='text' and @placeholder='Я хочу купить...' and @name='name']");
    private final SelenideElement applyButton = $x("//button[@type='submit' and contains(text(),'Применить')]");
    private final SelenideElement priceAdvert = $x("//h2[@class='h2' and contains(text(),'₽')]");
    private final SelenideElement advertPrice = $x("//h2[@class='h2' and contains(normalize-space(), '200 000 001')]");
    private final SelenideElement deleteButton = $x("//button[normalize-space()='Удалить']");
    private SelenideElement searchResult(String name) {
        return $x("//h2[@class='h2' and contains(text(),'" + name + "')]");
    }

    public void clickApplyButton() {

        applyButton.shouldBe(visible, enabled).click();
    }

    public void clickAdvertCard() {
        advertCard
                .shouldBe(Condition.visible, Duration.ofSeconds(6))
                .click();
    }

    public void search(String text) {
        searchInput.shouldBe(visible).setValue(text);
        clickApplyButton();
    }

    public void checkPriceVisible() {

        priceAdvert.shouldBe(visible);
    }

    public void checkAdvertIsVisible(String name) {
        searchResult(name)
                .shouldBe(visible)
                .shouldHave(text(name));
    }

    public String getAdvertPrice() {
        return
                advertPrice.shouldBe(visible).getText();
    }
    public void clickDeleteCard(){
        deleteButton
                .shouldBe(Condition.visible,Duration.ofSeconds(6))
                .click();
    }
}