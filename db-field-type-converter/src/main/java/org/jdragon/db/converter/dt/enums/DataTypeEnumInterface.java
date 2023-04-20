package org.jdragon.db.converter.dt.enums;

import java.sql.Types;

/**
 * @Author: JDragon
 * @Data:2023/3/31 1:04
 * @Description:
 */
public interface DataTypeEnumInterface {
    String getAlias();

    String getName();

    DataTypeGroup getGroup();

    Types getSqlType();

    default Integer getMaxLength() {
        return -1;
    }

    default Integer getMaxPrecision() {
        return -1;
    }

}
