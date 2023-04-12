package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Clickhouse 数据类型
 *
 * @author
 * @date:
 */
public enum ClickhouseDataType {
    //新增
    Int8,
    Int16,
    Int32,
    Int64,
    Int128,
    Int256,
    UInt8,
    UInt16,
    UInt32,
    UInt64,
    UInt128,
    UInt256,
    Float32,
    Float64,
    Decimal,
    DECIMAL64,
    Bool,
    String,
    FixedString,
    UUID,
    Date,
    DateTime,
    DateTime64,
    IPv4,
    IPv6,
    ;

    /**
     * 自己定义一个静态方法,通过code返回枚举常量对象
     *
     * @param code
     * @return
     */
    public static ClickhouseDataType getByValue(int code) {

        for (ClickhouseDataType dt : values()) {
            if (dt.ordinal() == code) {
                return dt;
            }
        }
        return null;

    }

    /**
     * @return
     * @author liuqh
     * @date: 2019年11月21日
     */
    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        ClickhouseDataType[] mdts = ClickhouseDataType.values();
        for (ClickhouseDataType m : mdts) {
            names.add(m.name().toLowerCase());
        }

        return names;
    }

}


