package com.zikozee.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View Name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another Expensive Message " +    //lambda only runs in failure conditions
                "Make me only if you have to");

        //ASSERTJ
        assertThat(controller.index()).isEqualTo("index");
        assertThat(controller.index()).contains("ex");
    }

    @Test
    @DisplayName("Test Exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }

    @Disabled
    @DisplayName("Testing timeout that runs on a separate thread ")
    @Test
    void testTimeOutPrempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here  5555535");
        });
    }

    @Test
    @DisplayName("Test if the Java home is correct")
    void testAssumptionTrue() {// if not true it does not fail instead aborts

        assumeTrue("C:\\Program Files\\Amazon Corretto\\jdk11.0.8_10".equalsIgnoreCase(System.getenv("JAVA_HOME")));
    }

    @Test
    void testAssumptionTrueString() {

        assumeTrue("ZIKOZEE".equalsIgnoreCase("ZKOZEE"));
    }


    @EnabledOnOs(value = OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(value = OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(value = JRE.JAVA_8)
    @Test
    void testMeOnJAVA8() {

    }

    @EnabledOnJre(value = JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "zikoz")
    @Test
    void testIfUserZikoz() {

        assertTrue(System.getenv("USERNAME").equalsIgnoreCase("Zikoz"));
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "fred")
    @Test
    void testIfUserFred() {

    }
}