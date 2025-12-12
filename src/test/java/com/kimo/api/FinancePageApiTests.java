package com.kimo.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

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

}
