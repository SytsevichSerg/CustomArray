
package com.epam.task1.util;

import java.util.UUID;

public class IdGenerator {
    private static UUID id;

    public static UUID assignId(){
        return UUID.randomUUID();
    }
}
