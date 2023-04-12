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
        return "";
    }
}
