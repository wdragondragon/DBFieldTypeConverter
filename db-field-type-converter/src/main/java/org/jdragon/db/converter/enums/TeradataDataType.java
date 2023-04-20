package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: benwei cai
 * @create: 2023-04-03 12:02
 */
public enum TeradataDataType {

    BYTE,
    BLOB,
    VARBYTE,
    CHAR,
    CLOB,
    VARCHAR,
    DICIMAL,
    DATE,
    FLOAT,
    INTEGER,
    BYTEINT,
    SMALLINT,
    BIGINT,
    NUMBER,
    TIMESTAMP,
    TIME
    ;

    public static TeradataDataType getByValue(int code) {
        for (TeradataDataType dt : values()) {
            if (dt.ordinal() == code) {
                return dt;
            }
        }
        return null;

    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        TeradataDataType[] mdts = TeradataDataType.values();
        for (TeradataDataType m : mdts) {
            names.add(m.name().toLowerCase());
        }

        return names;
    }
}
