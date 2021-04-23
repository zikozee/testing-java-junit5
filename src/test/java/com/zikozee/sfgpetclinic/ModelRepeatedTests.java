package com.zikozee.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author : zikoz
 * @created : 23 Apr, 2021
 */
@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo, RepetitionInfo repetitionInfo){

        System.out.println("Running Test - " + testInfo.getDisplayName() + " - " + repetitionInfo.getCurrentRepetition());

    }
}
