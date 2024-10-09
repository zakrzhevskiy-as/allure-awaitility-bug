package com.example;

import io.qameta.allure.Allure;
import io.qameta.allure.awaitility.AllureAwaitilityListener;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class AllureAwaitilityTest {

    @BeforeAll
    static void precondition() {
        Allure.step("In precondition", () -> {
            Awaitility.setDefaultConditionEvaluationListener(new AllureAwaitilityListener());
        });
    }

    @AfterAll
    static void restore() {
        Allure.step("In restore");
    }

    @Test
    void stepsShouldAppearAfterAwaitility() {
        Allure.step("Before awaitility", () -> Assertions.assertTrue(true));
        Awaitility.await("First awaitility")
                .pollDelay(Duration.ofSeconds(5))
                .until(() -> true);
        Awaitility.await("Second awaitility")
                .pollDelay(Duration.ofSeconds(5))
                .until(() -> true);
        Allure.step("After awaitility", () -> Assertions.assertTrue(false));
    }

}