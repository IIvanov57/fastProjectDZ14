package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GeneralPage;

import java.util.Arrays;
import java.util.List;


public class GeneralPageTests extends TestBase {
    GeneralPage generalPage = new GeneralPage();
    String headerForCreateDebetCard = "Дебетовая Альфа-Карта";
    private static final List<String> contentsForAll = Arrays.asList("Дебетовые карты", "Кредитные карты", "Инвестиции");
    private static final List<String> contentsForSmallBusiness = Arrays.asList("Счёт для бизнеса", "Депозиты", "Карты","Отраслевые решения");
    private static final List<String> contentsForBigBusiness = Arrays.asList("Расчётный счёт", "Эквайринг", "ВЭД", "Зарплатный проект");

    @DisplayName("Проверка наличия и кликабельности кнопки 'Получить карту' на главной страницы")
    @Test
    void checkButtonGetCardTest() {

        generalPage.openPage()
                .clickButtonGetCard()
                .checkAvailableText(headerForCreateDebetCard);

    }


    @DisplayName("Проверка раздела 'Выбирайте лучшее -> меню 'Для всех'")
    @Test
    void checkBestSelectInGeneralPageForAll() {
        generalPage.openPage()
                .checkContentForAll(contentsForAll);
    }

    @DisplayName("Проверка раздела 'Выбирайте лучшее -> меню 'Малому бизнесу'")
    @Test
    void checkBestSelectInGeneralPageForSmallBusiness() {
        generalPage.openPage()
                .checkContentForSmallBusiness(contentsForSmallBusiness);
    }

    @DisplayName("Проверка раздела 'Выбирайте лучшее -> меню 'Крупному бизнесу'")
    @Test
    void checkBestSelectInGeneralPageForBigBusiness() {
        generalPage.openPage()
                .checkContentForBigBusiness(contentsForBigBusiness);
    }

    @DisplayName("Проверка меню калькулятора")
    @Test
    void checkCalculator(){
        generalPage.openPage()
                .availableMenuCalculator();
    }
}
