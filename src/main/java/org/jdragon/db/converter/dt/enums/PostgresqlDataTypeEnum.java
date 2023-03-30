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
public enum PostgresqlDataTypeEnum implements DataTypeEnumInterface {

    ;

    @Getter
    private final String name;

    @Getter
    private final String group;

    @Getter
    private final Types sqlType;

    @Getter
    private final String alias;

    PostgresqlDataTypeEnum(String name, String group, Types sqlType) {
        this.name = name;
        this.alias = name;
        this.group = group;
        this.sqlType = sqlType;
    }
}
