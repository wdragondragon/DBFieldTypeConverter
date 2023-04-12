package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class GaussDBHelper extends DriverHelper {

    public GaussDBHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:gaussdb://%s/%s";
    }

    @Override
    public String getDriver() {
        return "com.huawei.gauss200.jdbc.Driver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.gaussdb;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE TABLE \"full_type\"\n" +
                "(\n" +
                "    \"t_int2\"          int2,\n" +
                "    \"t_int4\"          int4,\n" +
                "    \"t_int8\"          int8,\n" +
                "    \"t_float4\"        float4,\n" +
                "    \"t_float8\"        float8,\n" +
                "    \"t_numeric\"       numeric,\n" +
                "    \"t_serial4\"       serial2,\n" +
                "    \"t_serial8\"       serial4,\n" +
                "    \"t_serial2\"       serial8,\n" +
                "    \"t_bit\"           bit(255),\n" +
                "    \"t_varbit\"        varbit(255),\n" +
                "    \"t_bool\"          bool,\n" +
                "    \"t_box\"           box,\n" +
                "    \"t_bytea\"         bytea,\n" +
                "    \"t_varchar\"       varchar(255),\n" +
                "    \"t_char\"          char(255),\n" +
                "    \"t_cidr\"          cidr,\n" +
                "    \"t_inet\"          inet,\n" +
                "    \"t_circle\"        circle,\n" +
                "    \"t_date\"          date,\n" +
                "    \"t_interval\"      interval,\n" +
                "    \"t_lseg\"          lseg,\n" +
                "    \"t_macaddr\"       macaddr,\n" +
                "    \"t_money\"         money,\n" +
                "    \"t_decimal\"       numeric(10, 2),\n" +
                "    \"t_path\"          path,\n" +
                "    \"t_point\"         point,\n" +
                "    \"t_polygon\"       polygon,\n" +
                "    \"t_text\"          text,\n" +
                "    \"t_time\"          time,\n" +
                "    \"t_timetz\"        timetz,\n" +
                "    \"t_timestamp\"     timestamp,\n" +
                "    \"t_timestamptz\"   timestamptz,\n" +
                "    \"t_tsquery\"       tsquery,\n" +
                "    \"t_tsvector\"      tsvector,\n" +
                "    \"t_txid_snapshot\" txid_snapshot,\n" +
                "    \"t_uuid\"          uuid,\n" +
                "    \"t_xml\"           xml\n" +
                ")";
    }
}
