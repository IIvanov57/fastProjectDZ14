package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    private static final SelenideElement buttonGetFreeCard = $("[data-widget-name='ButtonV2']");
    private static final ElementsCollection textElements = $$("[data-test-id='text']");
    private static final SelenideElement elementForAll = $("[data-test-id='TabsHeader-retail']");
    private static final SelenideElement elementForSmallBusiness = $("[data-test-id='TabsHeader-mmb']");
    private static final SelenideElement elementForBigBusiness = $("[data-test-id='TabsHeader-bb']");
    private static final SelenideElement elementCredit = $("[data-test-id='TabsHeader-pil']");
    private static final SelenideElement elementMortgage  = $("[data-test-id='TabsHeader-mrt']");
    private static final SelenideElement elementDeposit  = $("[data-test-id='TabsHeader-deposit']");

    @Step("Открыть главную страницу")
    public GeneralPage openPage() {
        open("https://alfabank.ru/");
        return this;
    }

    @Step("Нажать на кнопку 'Получить карту'")
    public GeneralPage clickButtonGetCard() {
        buttonGetFreeCard.click();
        return this;
    }

    @Step("Проверить наличие контента {textFind}")
    public void checkAvailableText(String textFind) {
        textElements.findBy(text(textFind)).shouldHave(text(textFind));
    }

    @Step("Проверить наличие контента")
    public void checkAvailableText(List<String> textsFind) {
        textsFind.forEach(text -> textElements.findBy(text(text)).shouldHave(text(text)));
    }



    private GeneralPage clickElement(SelenideElement element) {
        element.click();
        return this;
    }

    @Step("Проверить то что меню переключилось")
    public GeneralPage checkClickabilityElement(SelenideElement element) {
        Assertions.assertEquals(element.getAttribute("aria-selected"), "true");
        return this;
    }

    public void checkContentForAll(List<String> contents){
        clickElement(elementForAll)
                .checkClickabilityElement(elementForAll)
                .checkAvailableText(contents);

    }

    public void checkContentForSmallBusiness(List<String> contents){
        clickElement(elementForSmallBusiness)
                .checkClickabilityElement(elementForSmallBusiness)
                .checkAvailableText(contents);

    }

    public void checkContentForBigBusiness(List<String> contents){
        clickElement(elementForBigBusiness)
                .checkClickabilityElement(elementForBigBusiness)
                .checkAvailableText(contents);

    }

    @Step("Проверить переключение элемента меню калькулятора")
    public void availableMenuCalculator(){
        elementCredit.click();
        checkClickabilityElement(elementCredit);

        elementMortgage.click();
        checkClickabilityElement(elementMortgage);

        elementDeposit.click();
        checkClickabilityElement(elementDeposit);
    }


}
