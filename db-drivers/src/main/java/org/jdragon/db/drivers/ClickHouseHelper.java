package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class ClickHouseHelper extends DriverHelper {

    public ClickHouseHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:clickhouse://%s/%s";
    }

    @Override
    public String getDriver() {
        return "ru.yandex.clickhouse.ClickHouseDriver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.clickhouse;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "SET allow_experimental_geo_types = 1;\n" +
                "create table full_type\n" +
                "(\n" +
                "    t_int8         Int8,\n" +
                "    t_int16        Int16,\n" +
                "    t_int32        Int32,\n" +
                "    t_int64        Int64,\n" +
                "    t_int128       Int128,\n" +
                "    t_int256       Int256,\n" +
                "    t_u_int8       UInt8,\n" +
                "    t_u_int16      UInt16,\n" +
                "    t_u_int32      UInt32,\n" +
                "    t_u_int64      UInt64,\n" +
                "    t_u_int128     UInt128,\n" +
                "    t_u_int256     UInt256,\n" +
                "    t_float32      Float32,\n" +
                "    t_float64      Float64,\n" +
                "    t_decimal      Decimal(5, 2),\n" +
                "    t_bool         Bool,\n" +
                "    t_string       String,\n" +
                "    t_fixed_string FixedString(255),\n" +
                "    t_uuid         UUID,\n" +
                "    t_date         Date,\n" +
                "    t_date32       Date32,\n" +
                "    t_datetime     DateTime,\n" +
                "    t_datetime32   DateTime32,\n" +
                "    t_datetime64   DateTime64,\n" +
                "    t_ip_4         IPv4,\n" +
                "    t_ip_6         IPv6,\n" +
                "    p              Point,\n" +
                "    r              Ring,\n" +
                "    pg             Polygon,\n" +
                "    mpg            MultiPolygon,\n" +
                "    -- 以下字段暂不支持\n" +
                "    t_nested Nested(params Array(String)),\n" +
                "    t_a_int8 Array(Int8),\n" +
                "    t_a_u_int8 Array(UInt8),\n" +
                "    t_a_bool Array(Bool),\n" +
                "    t_a_string Array(String),\n" +
                "    t_a_decimal Array(Decimal(5, 2)),\n" +
                "    t_a_float32 Array(Float32),\n" +
                "    t_a_date Array(Date),\n" +
                "    t_a_datetime Array(DateTime),\n" +
                "    t_a_ip_4 Array(IPv4),\n" +
                "    t_a_ip_6 Array(IPv6),\n" +
                "    t_enum8 Enum8('hello' = 1, 'world' = 2),\n" +
                "    t_enum16 Enum16('hello' = 1, 'world' = 2),\n" +
                "    t_low_cardinality_strings LowCardinality(String),\n" +
                "    t_map Map(UInt32,String)\n" +
                ") engine = MergeTree ORDER BY t_int8\n" +
                "      SETTINGS index_granularity = 8192;";
    }
}
