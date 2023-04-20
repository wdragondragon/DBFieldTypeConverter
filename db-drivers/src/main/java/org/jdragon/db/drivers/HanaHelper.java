package org.jdragon.db.drivers;

import lombok.Getter;
import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;

/**
 * @author: benwei cai
 * @create: 2023-04-19 18:55
 */
public class HanaHelper extends DriverHelper {

    @Getter
    private SourcesEnum type = SourcesEnum.hana;

    @Getter
    private String driver = "com.sap.db.jdbc.Driver";

    @Getter
    private String jdbc = "jdbc:sap://%s/%s";

    public HanaHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE COLUMN TABLE \"ADMIN\".\"full_type\" (\n" +
                "\"COLUMN1\" VARCHAR(100),\n" +
                "\"COLUMN2\" SMALLINT ,\n" +
                "\"COLUMN3\" TIME ,\n" +
                "\"COLUMN4\" TEXT ,\n" +
                "\"COLUMN5\" SECONDDATE ,\n" +
                "\"COLUMN6\" TIMESTAMP,\n" +
                "\"COLUMN7\" BINTEXT,\n" +
                "\"COLUMN8\" NVARCHAR(50),\n" +
                "\"COLUMN9\" REAL ,\n" +
                "\"COLUMN10\" DATE ,\n" +
                "\"COLUMN11\" NCLOB ,\n" +
                "\"COLUMN12\" CHAR(50),\n" +
                "\"COLUMN13\" INTEGER,\n" +
                "\"COLUMN14\" DECIMAL(10,2),\n" +
                "\"COLUMN15\" BIGINT,\n" +
                "\"COLUMN16\" BINARY(10),\n" +
                "\"COLUMN17\" CLOB,\n" +
                "\"COLUMN18\" TINYINT,\n" +
                "\"COLUMN19\" BLOB,\n" +
                "\"COLUMN20\" VARBINARY(100),\n" +
                "\"COLUMN21\" BOOLEAN,\n" +
                "\"COLUMN22\" DOUBLE) UNLOAD PRIORITY 5 AUTO MERGE;";
    }
}
