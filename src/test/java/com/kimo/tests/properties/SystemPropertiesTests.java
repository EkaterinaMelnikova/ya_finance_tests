package com.kimo.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void yaPropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void yaProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    @Tag("one_property")
    void yaProperty2Test() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
        // gradle clean one_property_test
        //  .\gradlew clean one_property_test если вар1 не работает


        // gradle clean one_property_test -Dbrouser=chrome
        //.\gradlew clean one_property_test -Dbrowser=chrome если вар1 не работает
        //.\gradlew clean test -Dbrowser=chrome --info
        //.\gradlew clean test -Dbrowser=chrome --debug
    }


    @Test
    @Tag("hello")
    void simpleProperty5Test() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));

        /*
        .\gradlew clean hello_test
            Hello, unknown student

        .\gradlew clean hello_test -Duser_name=Alex
            Hello, Alex

        gradle clean hello_test -Duser_name=Alex Egorov
            FAILURE: Build failed with an exception.
            Task 'Egorov' not found in root project 'qa-guru-jenkins-16'.

        gradle clean hello_test "-Duser_name=Alex Egorov"
        .\gradlew  clean hello_test -Duser_name="Alex Egorov"
            Hello, Alex Egorov
         */
    }


}
