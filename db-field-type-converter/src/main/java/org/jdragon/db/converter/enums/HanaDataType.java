package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: benwei cai
 * @create: 2023-04-19 20:24
 */
public enum HanaDataType {

    VARCHAR,
    SMALLINT,
    TIME,
    TEXT,
    SECONDDATE,
    TIMESTAMP,
    BINTEXT,
    NVARCHAR,
    REAL,
    DATE,
    NCLOB,
    CHAR,
    INTEGER,
    DECIMAL,
    BIGINT,
    BINARY,
    CLOB,
    TINYINT,
    BLOB,
    VARBINARY,
    BOOLEAN,
    DOUBLE,
    SMALLDECIMAL
    ;


    public static HanaDataType getByValue(int code) {

        for (HanaDataType dt : values()) {
            if (dt.ordinal() == code) {
                return dt;
            }
        }
        return null;

    }


    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        HanaDataType[] mdts = HanaDataType.values();
        for (HanaDataType m : mdts){
            names.add(m.name().toLowerCase());
        }

        return names;
    }

}
