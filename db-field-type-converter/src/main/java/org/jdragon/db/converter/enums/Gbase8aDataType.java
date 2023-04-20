package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: benwei cai
 * @create: 2023-04-03 12:02
 */
public enum Gbase8aDataType {

    TINYINT,
    SMALLINT,
    INTEGER,
    INT8,
    BIGINT,
    FLOAT,
    DOUBLE,
    DECIMAL,
    CHAR,
    VARCHAR,
    BINARY,
    TEXT,
    BLOB,
    VARBINARY,
    TINYBLOB,
    MEDIUMBLOB,
    LONGBLOB,
    DATE,
    DATETIME,
    TIME,
    TIMESTAMP,
    BOOL
    ;

    public static Gbase8aDataType getByValue(int code) {
        for (Gbase8aDataType dt : values()) {
            if (dt.ordinal() == code) {
                return dt;
            }
        }
        return null;

    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        Gbase8aDataType[] mdts = Gbase8aDataType.values();
        for (Gbase8aDataType m : mdts) {
            names.add(m.name().toLowerCase());
        }

        return names;
    }
}
