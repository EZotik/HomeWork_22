package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    private ElementsCollection cells = $$(".rt-td");
    private SelenideElement message = $(".rt-noData");

    @Step("Открыть страницу регистрации")
    public ProfilePage openPage() {
        open("/profile");
        return this;
    }
    @Step("Проверить отсутствие книг в списке")
    public ProfilePage checkEmptyCells() {
        for (SelenideElement cell : cells) {
            cell.shouldHave(Condition.empty);
        }
        return this;
    }
    @Step("Проверить наличие сообщения")
    public ProfilePage checkNoDataMessage() {
        message.shouldHave(text("No rows found"));
        return this;
    }

}
