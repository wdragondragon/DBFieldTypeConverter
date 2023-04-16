package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class HiveHelper extends DriverHelper {

    public HiveHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:hive2://%s/%s";
    }

    @Override
    public String getDriver() {
        return "org.apache.hive.jdbc.HiveDriver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.hive;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "create table full_type\n" +
                "(\n" +
                "    t_tinyint   tinyint,\n" +
                "    t_smallint  smallint,\n" +
                "    t_int       int,\n" +
                "    t_bigint    bigint,\n" +
                "    t_boolean   boolean,\n" +
                "    t_float     float,\n" +
                "    t_double    double,\n" +
                "    t_string    string,\n" +
                "    t_decimal   decimal,\n" +
                "    t_date      date,\n" +
                "    t_timestamp timestamp,\n" +
                "    t_char      char(255)\n" +
                ")";
    }
}
