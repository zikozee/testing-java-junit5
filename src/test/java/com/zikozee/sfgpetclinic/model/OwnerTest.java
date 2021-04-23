package com.zikozee.sfgpetclinic.model;

import com.zikozee.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("07066616366");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did not Match"),
                        () -> assertEquals("07066616366", owner.getTelephone()))
        );

        //HAMCREST
        assertThat(owner.getCity(), is("Key West"));
        assertThat(owner.getCity(), endsWith("West"));
        assertThat(owner.getCity(), startsWith("Ke"));
    }
}