package com.gui.tools;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static java.util.Collections.*;

/**
 * Class that simplifies convertions between String anc Collection types
 */
@Converter
public class StringListConverter implements AttributeConverter<Collection<String>, String> {
    private static final String SPLIT_CHAR = ";";

    /**
     * Method that transforms a Collection into a String
     * @param stringList
     * @return String
     */

    @Override
    public String convertToDatabaseColumn(Collection<String> stringList) {
        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
    }

    /**
     * Method that transforms a String into a COllection
     * @param string
     * @return Collection
     */
    @Override
    public Collection<String> convertToEntityAttribute(String string) {
        return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) : emptyList();
    }
}
