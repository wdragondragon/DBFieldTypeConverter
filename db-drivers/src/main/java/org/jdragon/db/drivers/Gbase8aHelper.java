package org.jdragon.db.drivers;

import lombok.Getter;
import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;

/**
 * @author: benwei cai
 * @create: 2023-04-19 18:55
 */
public class Gbase8aHelper extends DriverHelper {

    @Getter
    private SourcesEnum type = SourcesEnum.gbase8a;

    @Getter
    private final String driver = "com.gbase.jdbc.Driver";

    @Getter
    private final String jdbc = "jdbc:gbase://%s/%s";

    public Gbase8aHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE TABLE IF NOT EXISTS full_type (\n" +
                "        column1 BIGINT,\n" +
                "        column2 BLOB,\n" +
                "        column3 CHAR(50),\n" +
                "        column4 DATE,\n" +
                "        column5 DATETIME,\n" +
                "        column6 DECIMAL(10,0),\n" +
                "        column7 DOUBLE,\n" +
                "        column8 FLOAT,\n" +
                "        column9 INT,\n" +
                "        column10 SMALLINT,\n" +
                "        column11 TEXT,\n" +
                "        column12 TIME,\n" +
                "        column13 TIMESTAMP,\n" +
                "        column14 TINYINT,\n" +
                "        column15 VARCHAR(50),\n" +
                "        column16 VARBINARY(100),\n" +
                "        column17 LONGBLOB,\n" +
                "        column18 TINYBLOB,\n" +
                "        column19 BINARY(10),\n" +
                "        column20 BOOL,\n" +
                "        column21 MEDIUMBLOB,\n" +
                "        column22 MEDIUMINT\n" +
                ");";
    }
}
