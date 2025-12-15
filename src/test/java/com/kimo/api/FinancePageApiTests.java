package com.kimo.api;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class FinancePageApiTests {

    @Test
    void OpenFinancePageTest() {

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .when()
                .post("https://yandex.ru/finance")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body(containsString("<title>Яндекс — поиск по финансам: вкладам, картам, ипотекам, кредитам и ОСАГО</title>"));
    }


    @Test
    void OpenCreditPageTest() {

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .when()
                .get("https://yandex.ru/finance/credit")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body(containsString("<title>Кредиты. Яндекс - поиск по финансам</title>"));;
    }

    @Test
    void OpenOSAGOPageTest() {

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .when()
                .get("https://yandex.ru/finance/osago/calculator")
                .then()
                .log().status()
                .statusCode(200)
                .body(containsString("<title>ОСАГО — узнайте цены от 17 страховых и купите полис онлайн</title>"));;

    }

    @Test
    void OpenMortgagePageTest() {

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .when()
                .get("https://yandex.ru/finance/mortgage")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body(containsString("<title>Ипотечные программы. Яндекс - поиск по финансам</title>"));;
    }

    @Test
    void OpenFinanceDictionaryPageTest() {

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .when()
                .get("https://yandex.ru/finance/dictionary/n")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body(containsString("<title>Словарь экономических терминов — термины на букву Н</title>"));;
    }

}
