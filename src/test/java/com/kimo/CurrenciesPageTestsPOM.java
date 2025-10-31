package com.kimo;

import Pages.CurrenciesPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("finance")
public class CurrenciesPageTestsPOM extends TestBase {

    CurrenciesPage currenciesPage = new CurrenciesPage();


    @Test
    @DisplayName("Проверка отображения/скрытия полного текста по нажатию Читать еще/Скрыть")
    void openReadMoreTest() {


        step("Открыть страницу Курсы валют", () -> {
            currenciesPage.openPage();
        });

        step("Кликнуть Читать еще", () -> {
            currenciesPage.clickReadMore();
        });

        step("Проверить что текст отображается полностью", () -> {
            currenciesPage.checkFullTextVisible();
        });

        step("Кликнуть скрыть", () -> {
            currenciesPage.clickHide();
        });

        step("Проверить что полный текст скрыт", () -> {
            currenciesPage.checkFullTextHidden();
        });

    }

    @Test
    @DisplayName("Проверка увеличения количества отображаемых валют по нажатию Показать еще")
    void expandCurrencyListOnShowMoreClick() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        int currencyAmount = 7;
        int currencyAmount1 = 17;


        step("Открыть страницу Курсы валют", () -> {
            currenciesPage.openPage();
        });

        step("Проверить кол-во отображаемых валют", () -> {
            currenciesPage.checkCurrencyAmount(currencyAmount);
        });

        step("Кликнуть Показать еще", () -> {
            currenciesPage.clickShowMore();
        });

        step("Проверить что список валют увеличился", () -> {
            currenciesPage.checkCurrencyAmountAfterClickShowMore1(currencyAmount1);
        });

    }

    @Test
    @DisplayName("Проверка открытия  детальной информации о валюте по нажатию на ее название")
    void clickOnSpecificCurrency() {

        String currencyName = "USD";


        step("Открыть страницу Курсы валют", () -> {
            currenciesPage.openPage();
        });

        step("Кликнуть на наименование валюты", () -> {
            currenciesPage.clickCurrencyName(currencyName);
        });

        step("Проверить что в заголовке окна выбранная валюта", () -> {
            currenciesPage.checkCurrencyNameOnThePage(currencyName);
        });

    }


}





