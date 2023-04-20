package org.jdragon.db.converter.dt.enums;

import org.jdragon.db.converter.dt.converter.FieldTypeConverter;
import org.jdragon.db.drivers.SourcesEnum;

import java.util.HashMap;
import java.util.Map;

public class DataTypeConverterContainer {

    private static final Map<SourcesEnum, FieldTypeConverter> map = new HashMap<>();


    public static void put(SourcesEnum key, FieldTypeConverter value) {
        map.put(key, value);
    }

    public static FieldTypeConverter get(SourcesEnum key) {
        return map.get(key);
    }
}
