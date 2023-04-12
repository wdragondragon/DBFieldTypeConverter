package org.jdragon.db.converter;

import org.jdragon.db.drivers.MysqlHelper;
import org.jdragon.db.drivers.OracleHelper;
import org.jdragon.db.drivers.PostgresqlHelper;
import org.jdragon.db.drivers.SqlserverHelper;
import org.jdragon.db.drivers.api.DriverHelper;

import java.sql.SQLException;

public class DBFieldTypeConverter {
    public static void main(String[] args) throws SQLException {
//        DriverHelper driverHelper = new MysqlHelper("192.168.1.150:3305", "datax_test", "root", "951753", null);
//        DriverHelper driverHelper = new OracleHelper("192.168.1.150:1521", "helowin", "test", "test", null);
//        DriverHelper driverHelper = new SqlserverHelper("192.168.1.150:1433", "master", "SA", "Zhjl.sqlserver", null);
        DriverHelper driverHelper = new PostgresqlHelper("192.168.1.150:15432", "jdragon", "jdragon", "Zhjl.postgres", null);
        driverHelper.createFullTypeTable();
        driverHelper.printFullType();
    }

}