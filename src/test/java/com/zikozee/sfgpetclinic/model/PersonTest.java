package com.zikozee.sfgpetclinic.model;

import com.zikozee.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1L, "Joe", "Buck");

        //then
        assertAll("Test Prop Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1L, "Joe", "Buck");

        //then
        assertAll("Test Prop Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last Name Failed"));
    }

    @DisplayName(value = "using assertJ with Junit")
    @Test
    void collectionTestWithAssertJ() {
        Person person1 = new Person(1L, "Ziko", "Zee");
        Person person2 = new Person(2L, "Bobby", "Ray");
        Person person3 = new Person(3L, "Bambu", "Bee");
        List<Person> persons = Arrays.asList(person1, person2);

        assertAll("Test Collection",
                () -> assertThat(person2).isIn(persons),
                () -> assertThat(person3).isNotIn(persons),
                () -> assertThat(person1).matches(person -> person.getFirstName().equals("Ziko") && person.getLastName().equals("Zee")),
                () -> assertThat(persons).isNotEmpty(),
                () -> assertThat(persons).filteredOn(person -> !person.getFirstName().equals("bee"))
                        .filteredOn(person -> person.getFirstName().length() > 3)
                        .first().isInstanceOf(Person.class)
        );

    }


}