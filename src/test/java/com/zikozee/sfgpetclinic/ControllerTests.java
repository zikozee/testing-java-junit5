package com.zikozee.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * @author : zikoz
 * @created : 23 Apr, 2021
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("Lets do something here");// this requires the @TestInstance
    }
}
