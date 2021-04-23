package com.zikozee.sfgpetclinic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @author : zikoz
 * @created : 23 Apr, 2021
 */
public class CustomArgsProvider implements ArgumentsProvider {

    //you could return value from a db, mq, reading xml, json about anything can be done here
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of("EB", 7, 10),
                Arguments.of("AB", 11, 4),
                Arguments.of("LA", 44, 77));
    }
}
