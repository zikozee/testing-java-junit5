package com.zikozee.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author : zikoz
 * @created : 23 Apr, 2021
 */
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo){
        System.out.println("Running Test - " + testInfo.getDisplayName());

    }
}
