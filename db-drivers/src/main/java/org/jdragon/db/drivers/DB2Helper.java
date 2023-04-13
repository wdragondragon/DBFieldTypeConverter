package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class DB2Helper extends DriverHelper {

    public DB2Helper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:db2://%s/%s";
    }

    @Override
    public String getDriver() {
        return "com.ibm.db2.jcc.DB2Driver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.db2;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "create table full_type\n" +
                "(\n" +
                "    t_smallint    SMALLINT,\n" +
                "    t_int         INT,\n" +
                "    t_bigint      BIGINT,\n" +
                "    t_real        real,\n" +
                "    t_float       FLOAT,\n" +
                "    t_double      double,\n" +
                "    t_numeric     numeric(10, 2),\n" +
                "    t_decimal     decimal(10, 2),\n" +
                "    t_char        char(255),\n" +
                "    t_nchar       nchar,\n" +
                "    t_varchar     varchar(255),\n" +
                "    t_clob        clob,\n" +
                "    t_graphic     graphic,\n" +
                "    t_dbclob      dbclob,\n" +
                "    t_blob        blob(2 G),\n" +
                "    t_date        date,\n" +
                "    t_time        time,\n" +
                "    t_timestamp   timestamp,\n" +
                "    t_xml         xml,\n" +
                "    t_binary      binary,\n" +
                "    t_varbinary   varbinary(255),\n" +
                "    t_var_graphinc vargraphic(255)\n" +
                ")";
    }
}
