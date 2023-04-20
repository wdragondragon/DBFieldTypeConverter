package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.HashMap;
import java.util.Map;

public class DBHelperContainer {

    private static final Map<SourcesEnum, DriverHelper> map = new HashMap<>();

    public static void put(SourcesEnum key, DriverHelper value) {
        map.put(key, value);
    }
    public static DriverHelper get(SourcesEnum key) {
        return map.get(key);
    }
}
