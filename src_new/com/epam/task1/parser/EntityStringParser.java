package com.epam.task1.parser;

import com.epam.task1.exception.EntityArrayException;
import java.util.List;

public interface EntityStringParser {

    int[] parse(String line);

    List<Integer> parseAll(List<String> lines) throws EntityArrayException;
}
