
package com.epam.task1_2.util;

import java.util.UUID;

public class IdGenerator {
    private static UUID id;

    public static UUID assignId(){
        return UUID.randomUUID();
    }
}
