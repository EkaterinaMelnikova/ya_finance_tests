# Проект по автоматизации тестирования приложения Яндекс.Финансы
<img width="100%" style="vertical-align:middle" title="yandex.ru/finance" src="images/screenshots/yandex_finance.png">

## :pushpin: Содержание:

- [Описание](#open_book-описание)
- [Чек-лист проверок](#open_book-описание)
- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов](#running_woman-запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Примеры видео запуска тестов в Selenoid и Browserstack](#-примеры-видео-запуска-тестов-в-selenoid-и-browserstack)

## :open_book: Описание
В проекте реализованы UI тесты для веб приложения yandex_finance.


## 📋 Чек-лист проверок

### Главная страница (https://yandex.ru/finance)
- [ ] **TC-001**: Проверка поиска Курсов валют через строку Поиска
- [ ] **TC-002**: Проверка перехода в окно Курсы валют по кнопке Валюты > Показать все
- [ ] **TC-003**: Проверка открытия окна Курсы валют по ссылке Курсы валют в Популярных запросах
### Страница Курсы валют (https://yandex.ru/finance/currencies)
- [ ] **TC-004**: Проверка отображения/скрытия полного текста по нажатию Читать еще/Скрыть
- [ ] **TC-005**: Проверка открытия детальной информации о валюте по нажатию на ее название
- [ ] **TC-006**: Проверка увеличения количества отображаемых валют по нажатию Показать еще
### Страница Конвертер валют (https://yandex.ru/finance/currencies/USD_RUB)
- [ ] **TC-007**: Проверка отображения конвертируемой валюты после ее смены
- [ ] **TC-008**: Проверка актуальности даты текущего курса
- [ ] **TC-009**: Проверка отображения валют после нажатия кнопки Поменять местами значения


## :computer: Использованный стек технологий

<p align="center">
<code><img width="6%" title="IntelliJ IDEA" src="images/logo/IntelijIDEA.svg"></code>
<code><img width="6%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="6%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="6%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="6%" title="Allure TestOps" src="images/logo/AllureReport.svg"></code>
<code><img width="6%" title="Allure Report" src="images/logo/AllureTO.svg"></code>
<code><img width="6%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="6%" title="JUnit5" src="images/logo/JUnit5.svg"></code>
<code><img width="6%" title="GitHub" src="images/logo/GitHub.svg"></code>
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/).
Запуск тестов можно осуществлять локально или в [Selenoid](https://aerokube.com/selenoid/)

Allure-отчет включает в себя:
* шаги выполнения тестов;
* логирование отправленных API запросов
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

## :running_woman: Запуск тестов

### Локальный запуск тестов
Запуск web-тестов
```
./gradlew finance_test
```


### Запуск тестов на удаленном браузере
Для запуска web-тестов в selenoid
```
./gradlew finance_test
```



## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins

**Configure:**
- **Repository:** `https://github.com/EkaterinaMelnikova/ya_finance_tests.git` *(SCM > Git)*
- **Branch:** `*/remote` *(SCM > Branches to build)*
- **Gradle Version:** `Gradle 8.12` *(Build Steps > Invoke Gradle)*
- **Command:** `clean finance_test` *(Build Steps > Tasks)*
- **Allure Path:** `build/allure-results/` *(Allure Report)*


<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/AllureReport.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/allure_report.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportTest.png">
</p>

### <img width="4%" style="vertical-align:middle" title="AllureTO" src="images/logo/AllureTO.svg"> Интеграция с Allure TestOps
Тестовая сборка в Jenkins интегрирована с Allure TestOps. В Allure TestOps автоматически обновляется список тест-кейсов и результаты выполнения тестов.
<p align="center">
<img width="100%" title="Allure TestOps Cases - Feature view" src="images/screenshots/testOpsCasesFeature.png">
</p>

### Интеграция с Jira
Также полученные из автотестов тест-кейсы прикреплены к задаче в Jira.
<p align="center">
<img width="100%" title="Allure TestOps Cases - Feature view" src="images/screenshots/jiraIntegration.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/notificationExample.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"><img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Browserstack.svg"> Примеры видео запуска тестов в Selenoid и Browserstack

При запуске тестов в remote-окружении к каждому тесту в отчете прилагается видео.
<p>Пример видео из Selenoid</p>
<p align="center">
  <img title="Selenoid Video" src="images/gif/selenoidVideoExample.gif">
</p>

