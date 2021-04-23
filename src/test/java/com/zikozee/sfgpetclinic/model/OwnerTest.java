package com.zikozee.sfgpetclinic.model;

import com.zikozee.sfgpetclinic.CustomArgsProvider;
import com.zikozee.sfgpetclinic.ModelTests;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        assertAll("HAMCREST TESTS",
        //HAMCREST
                () -> assertThat(owner.getCity(), is("Key West")),
                () -> assertThat(owner.getCity(), endsWith("West")),
                () -> assertThat(owner.getCity(), startsWith("Ke"))
        );
    }

    //todo parameterized tests =>> it will run the test for each iteration of the parameter

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Badass", "Developer"})
    void testValueSource(String val) {
        System.out.println(val);

        assertThat(val, Arrays.asList("Spring", "Badass", "Developer").contains(val));
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);

        assertThat(ownerType.name(), Arrays.stream(OwnerType.values()).map(Enum::name).collect(Collectors.toList()).contains(ownerType.name()));
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 1, 1",
            "MI, 1, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);

        assertThat(stateName, Arrays.asList("FL", "OH", "MI").contains(stateName));
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv",numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);

        assertAll("Test csv values from file",
                () -> assertThat(stateName, Arrays.asList("FL", "OH", "MI").contains(stateName)),
                () -> Assertions.assertThat(Arrays.asList(3, 4, 12)).contains(val1),
                () -> Assertions.assertThat(Arrays.asList(3, 5, 15)).contains(val2));

    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource(value = "getArgs")
    void fromMethodTest(String newStateName, int val1, int val2) {
        System.out.println(newStateName + " - " + val1 + ":" + val2);

        assertAll("Test csv values from file",
                () -> assertThat(newStateName, Arrays.asList("FL", "OH", "MI").contains(newStateName)),
                () -> Assertions.assertThat(Arrays.asList(1, 2, 3)).contains(val1),
                () -> Assertions.assertThat(Arrays.asList(1, 8, 5)).contains(val2));

    }

    //todo you could talk 2 db, mq, reading xml, json about anything can be done here
    static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 5));
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(value = CustomArgsProvider.class)
    void fromCustomProviderTest(String newStateName, int val1, int val2) {
        System.out.println(newStateName + " - " + val1 + ":" + val2);

        assertAll("Test csv values from file",
                () -> assertThat(newStateName, Arrays.asList("EB", "AB", "LA").contains(newStateName)),
                () -> Assertions.assertThat(Arrays.asList(7, 11, 44)).contains(val1),
                () -> Assertions.assertThat(Arrays.asList(10, 4, 77)).contains(val2));

    }
}