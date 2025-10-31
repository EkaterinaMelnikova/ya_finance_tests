package com.kimo;

import Pages.CurrencyVisualizationPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("finance")
public class CurrencyVisualizationPageTestsPOM extends TestBase {


    CurrencyVisualizationPage currencyVisualizationPage = new CurrencyVisualizationPage();

    String currencyName = "USD";

    @Test
    @Disabled
    @DisplayName("Проверка актуальности даты текущего курса")
    void checkCurrentDate() {

        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открыть страницу Курс валюты", () -> {
            currencyVisualizationPage.openPage(currencyName);
        });


        step("Проверить что дата отображаемого курса актуальна", () -> {
            currencyVisualizationPage.pageDateShouldMatchCurrentDate();
        });


    }

    @Test
    @DisplayName("Проверка отображения конвертируемой валюты после ее смены")
    void checkCurrencyChange() {


        step("Открыть страницу Курс валюты", () -> {
            currencyVisualizationPage.openPage(currencyName);
        });


        step("Изменить значение конвертируемой валюты", () -> {
            currencyVisualizationPage.changeConvertCurrency(currencyName);
        });


        step("Проверить что наименование валюты соответствует выбранной", () -> {
            currencyVisualizationPage.checkConvertCurrency();
        });


    }

    @Test
    @DisplayName("Поверка отображения валют после нажатия кнопки Поменять местами значения")
    void chengeCurrencyPlaces() {


        step("Открыть страницу Курс валюты", () -> {
            currencyVisualizationPage.openPage(currencyName)
                    .saveCurrentCurrencies();
        });

        step("Нажать на кнопку Поменять местами", () -> {
            currencyVisualizationPage.swapCurrencies();
        });

        step("Проверить что наименования валют поменялись местами", () -> {
            currencyVisualizationPage.checkCurrenciesAfterSwap();
        });

    }
}





