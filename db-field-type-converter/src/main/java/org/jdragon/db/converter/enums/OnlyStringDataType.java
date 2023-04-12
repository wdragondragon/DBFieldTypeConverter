package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JDragon
 * @Date 2021.07.20 上午 10:11
 * @Email 1061917196@qq.com
 * @Des:
 */
public enum OnlyStringDataType {

    STRING;

    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        OnlyStringDataType[] mdts = OnlyStringDataType.values();
        for (OnlyStringDataType m : mdts){
            names.add(m.name().toLowerCase());
        }

        return names;
    }
}
