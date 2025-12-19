package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAdvertPage {

    private final SelenideElement createAdvert = $x("//button[text()='Разместить объявление']");
    private final SelenideElement uploadPhotoInput = $x("//input[@name='img1']");
    private final SelenideElement nameInput = $x("//input[@placeholder='Название']");
    private final SelenideElement categoryDropdownButton = $x("//input[@name='category']/following-sibling::button");
    private SelenideElement categoryOption(String name) {
        return $x("//span[normalize-space()='" + name + "']");
    }
    private final SelenideElement conditionNew = $x("//input[@name='condition' and @value='Новый']");
    private final SelenideElement cityMoscow = $x("//input[@name='city' and @value='Москва']");
    private final SelenideElement textField = $x("//textarea[@placeholder='Описание товара']");
    private final SelenideElement priceField = $x("//input[@placeholder='Стоимость']");
    private final SelenideElement publishButton = $x("//button[normalize-space()='Опубликовать']");

    public void clickCreateAdvert() {
        createAdvert.shouldBe(visible).click();
    }

    public void uploadPhoto() {

        uploadPhotoInput.uploadFromClasspath("img1.jpg");
    }

    public void setProductName(String productName) {
        nameInput.shouldBe(visible).clear();
        nameInput.setValue(productName);
    }

    public void selectCategory(String categoryName) {
        categoryDropdownButton.shouldBe(enabled).click();
        categoryOption(categoryName).shouldBe(visible).click();
    }

    public void selectNewCondition() {

        conditionNew.parent().click();
    }

    public void selectCityMoscow() {

        cityMoscow.shouldBe(visible).click();
    }

    public void enterDescription(String description) {
        textField.shouldBe(visible).clear();
        textField.setValue(description);
    }

    public void enterPrice(String price) {
        priceField.shouldBe(visible).clear();
        priceField.setValue(price);
    }

    public void clickPublishButton() {

        publishButton.shouldBe(visible).click();
    }
}