package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class OracleHelper extends DriverHelper {

    public OracleHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:oracle:thin:@//%s/%s";
    }

    @Override
    public String getDriver() {
        return "oracle.jdbc.OracleDriver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.oracle;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE TABLE \"FULL_TYPE\" \n" +
                "   (\t\"ID\" NUMBER, \n" +
                "\t\"T_INTEGER\" NUMBER(*,0), \n" +
                "\t\"T_FLOAT\" FLOAT(126), \n" +
                "\t\"T_REAL\" FLOAT(63), \n" +
                "\t\"T_NUMBER\" NUMBER, \n" +
                "\t\"T_CHAR\" CHAR(255), \n" +
                "\t\"T_VARCHAR2\" VARCHAR2(255), \n" +
                "\t\"T_NVARCHAR2\" NVARCHAR2(255), \n" +
                "\t\"T_BLOB\" BLOB, \n" +
                "\t\"T_CLOB\" CLOB, \n" +
                "\t\"T_DATE\" DATE, \n" +
                "\t\"T_TIMESTAMP\" TIMESTAMP (6), \n" +
                "\t\"T_DOUBLE\" FLOAT(126), \n" +
                "\t PRIMARY KEY (\"ID\")\n" +
                "  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING\n" +
                "  TABLESPACE \"USERS\"  ENABLE\n" +
                "   ) SEGMENT CREATION DEFERRED \n" +
                "  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING\n" +
                "  TABLESPACE \"USERS\" \n" +
                " LOB (\"T_BLOB\") STORE AS BASICFILE (\n" +
                "  TABLESPACE \"USERS\" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION \n" +
                "  NOCACHE LOGGING ) \n" +
                " LOB (\"T_CLOB\") STORE AS BASICFILE (\n" +
                "  TABLESPACE \"USERS\" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION \n" +
                "  NOCACHE LOGGING )";
    }
}
