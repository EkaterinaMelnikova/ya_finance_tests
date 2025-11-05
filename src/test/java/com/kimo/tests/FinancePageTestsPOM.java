package com.kimo.tests;

import Pages.FinancePage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

//@Tag("Jenkins")
public class FinancePageTestsPOM extends TestBaseRemote {

    FinancePage financePage = new FinancePage();

    String pageName = "Курсы валют";


    @Test
    @Tag("Jenkins")
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking the transition to the Exchange Rates window by clicking the Currencies > Show All button")
    void openCurrenciesPageTest() {

        step("Open the Yandex.Finance page", () -> {
            financePage.openPage();
        });

        step("Click on Currencies", () -> {
            financePage.clickLinkCurrencies();
        });

        step("Click Show All", () -> {
            financePage.clickLinkShowAll();
        });

        step("Check the title of the page that opens", () -> {
            financePage.checkPageName(pageName);
        });


    }

    @Test
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поиска Курсов валют через строку Поиска")
    void findCurrenciesPageViaSearchTest() {

        String searchText = "валют";

        step("Открыть страницу яндекс.финансы", () -> {
        financePage.openPage();
        });

        step("В строке поиска отправить запрос Курсы валют", () -> {
            financePage.enterSearchQuery(searchText);
        });

        step("Проверить заголовок открывшейся страницы", () -> {
            financePage.checkPageName(pageName);
        });

    }


    @Test
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка открытия окна Курсы валют по ссылке Курсы валют в Популярных запросах")
    void scrollСurrencyRightTest() {

        String linkText = "Курсы валют";

        step("Открыть страницу яндекс.финансы", () -> {
            financePage.openPage();
        });

        step("Кликнуть на ссылку Курсы валют в разделе Популярные запросы", () -> {
        financePage.selectFromPopularQueries(linkText);
        });

        step("Проверить заголовок открывшейся страницы", () -> {
        financePage.checkPageName(pageName);
        });
    }


}
