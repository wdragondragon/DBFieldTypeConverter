package org.jdragon.db.converter.dt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Types;

/**
 * @Author: JDragon
 * @Data:2023/3/31 1:05
 * @Description:
 */

@AllArgsConstructor
public enum MysqlDataTypeEnum implements DataTypeEnumInterface {

    INT("int", DataTypeGroup.NUMBER, null, 4, 0),
    TINYINT("tinyint", DataTypeGroup.NUMBER, null, 1, 0),
    MEDIUMINT("mediumint", DataTypeGroup.NUMBER, null, 3, 0),
    BIGINT("bigint", DataTypeGroup.NUMBER, null, 8, 0),
    FLOAT("float", DataTypeGroup.NUMBER, null, 24, 8),
    DOUBLE("double", DataTypeGroup.NUMBER, null, 48, 16),
    DECIMAL("decimal", DataTypeGroup.NUMBER, null, 65, 30),
    DATE("date", DataTypeGroup.DATE, null, 0, 0),
    TIME("time", DataTypeGroup.TIME, null, 6, 0),
    YEAR("year", DataTypeGroup.STRING, null, 4, 0),
    DATETIME("datetime", DataTypeGroup.DATE_TIME, null, 6, 0),
    TIMESTAMP("timestamp", DataTypeGroup.DATE_TIME, null, 6, 0),
    CHAR("char", DataTypeGroup.STRING, null, 255, 0),
    // utf8 情况下，占用3字节，最大能存放21844个字符
    VARCHAR("varchar", DataTypeGroup.STRING, null, 21844, 0),
    TINYBLOB("tinyblob", DataTypeGroup.BLOB),
    TINYTEXT("tinytext", DataTypeGroup.TEXT),
    BLOB("blob", DataTypeGroup.BLOB),
    MEDIUMBLOB("mediumblob", DataTypeGroup.BLOB),
    MEDIUMTEXT("mediumtext", DataTypeGroup.TEXT),
    TEXT("text", DataTypeGroup.TEXT),
    LONGBLOB("longblob", DataTypeGroup.BLOB),
    LONGTEXT("longtext", DataTypeGroup.TEXT),
    ;

    @Getter
    private final String name;

    @Getter
    private final DataTypeGroup group;

    @Getter
    private final Types sqlType;

    @Getter
    private final String alias;

    @Getter
    private final Integer maxLength;

    @Getter
    private final Integer maxPrecision;

    MysqlDataTypeEnum(String name, DataTypeGroup group) {
        this.name = name;
        this.alias = name;
        this.group = group;
        this.sqlType = null;
        this.maxLength = null;
        this.maxPrecision = null;
    }


    MysqlDataTypeEnum(String name, DataTypeGroup group, Types sqlType, Integer maxLength, Integer maxPrecision) {
        this.name = name;
        this.alias = name;
        this.group = group;
        this.sqlType = sqlType;
        this.maxLength = maxLength;
        this.maxPrecision = maxPrecision;
    }


}
