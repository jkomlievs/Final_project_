package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAdvertPage {

    private SelenideElement createAdvert = $x("//button[text()='Разместить объявление']");
    private SelenideElement uploadPhotoInput = $x("//input[@name='img1']");
    private SelenideElement nameInput = $x("//input[@placeholder='Название']");
    private SelenideElement categoryDropdownButton = $x("//input[@name='category']/following-sibling::button");

    private SelenideElement categoryOption(String name) {
        return $x("//span[normalize-space()='" + name + "']");
    }

    private SelenideElement conditionNew = $x("//input[@name='condition' and @value='Новый']");
    private SelenideElement conditionUsed = $x("//input[@name='condition' and @value='Б/У']");

    private SelenideElement cityDropdown = $x("//div[@class='dropDownMenu_input__itKtw']");
    private SelenideElement cityMoscow = $x("//input[@name='city' and @value='Москва']");

    private SelenideElement textField = $x("//textarea[@placeholder='Описание товара']");
    private SelenideElement priceField = $x("//input[@placeholder='Стоимость']");
    private SelenideElement publishButton = $x("//button[normalize-space()='Опубликовать']");

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

    public void openCityDropdown() {
        cityDropdown.shouldBe(visible).click();
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