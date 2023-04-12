package org.jdragon.db.drivers;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class SQLTypesMap {

    private static final Map<Integer, String> map = new HashMap<>();

    static {
        Field[] declaredFields = Types.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                map.put((Integer) declaredField.get(null), declaredField.getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static String get(int key) {
        return map.get(key);
    }
}
