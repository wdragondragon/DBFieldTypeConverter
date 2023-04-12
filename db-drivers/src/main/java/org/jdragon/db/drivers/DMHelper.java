package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;


public class DMHelper extends DriverHelper {

    public DMHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:dm://%s/%s";
    }

    @Override
    public String getDriver() {
        return "dm.jdbc.driver.DmDriver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.dm;
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
                "\t\"T_DOUBLE\" FLOAT(126)\n" +
                "   ) ";
    }
}
