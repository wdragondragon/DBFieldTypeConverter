package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class SqlserverHelper extends DriverHelper {

    public SqlserverHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:sqlserver://%s;DatabaseName=%s";
    }

    @Override
    public String getDriver() {
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.sqlserver;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "create table full_type\n" +
                "(\n" +
                "    t_char             char(255),\n" +
                "    t_varchar          varchar(255),\n" +
                "    t_text             text,\n" +
                "    t_nchar            nchar(255),\n" +
                "    t_nvarchar         nvarchar,\n" +
                "    t_ntext            ntext,\n" +
                "    t_bit              bit,\n" +
                "    t_binary           binary,\n" +
                "    t_image            image,\n" +
                "    t_tinyint          tinyint,\n" +
                "    t_smallint         smallint,\n" +
                "    t_int              int,\n" +
                "    t_bigint           bigint,\n" +
                "    t_decimal          decimal,\n" +
                "    t_numeric          numeric,\n" +
                "    t_smallmoney       smallmoney,\n" +
                "    t_money            money,\n" +
                "    t_float            float,\n" +
                "    t_real             real,\n" +
                "    t_datetime         datetime,\n" +
                "    t_datetime2        datetime2,\n" +
                "    t_smalldatetime    smalldatetime,\n" +
                "    t_date             date,\n" +
                "    t_time             time,\n" +
                "    t_datetimeoffset   datetimeoffset,\n" +
                "--     t_sql_variant      sql_variant,\n" +
                "    t_uniqueidentifier uniqueidentifier,\n" +
                "    t_xml              xml\n" +
                ")";
    }
}
