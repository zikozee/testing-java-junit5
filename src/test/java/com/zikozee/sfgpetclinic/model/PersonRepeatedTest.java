package com.zikozee.sfgpetclinic.model;

import com.zikozee.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * @author : zikoz
 * @created : 23 Apr, 2021
 */
class PersonRepeatedTest implements ModelRepeatedTests {

    //ctrl - click @RepeatedTest
//    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("My Repeated Test")
    void myRepeatedTests() {
        //todo - impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {

        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());

    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
    @DisplayName("My Assignment Repeated Test")
    void myAssignmentRepeated() {
        //todo impl
    }
}
