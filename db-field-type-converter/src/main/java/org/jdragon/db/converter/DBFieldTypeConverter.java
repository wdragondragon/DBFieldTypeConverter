package org.jdragon.db.converter;

import org.jdragon.db.drivers.*;
import org.jdragon.db.drivers.api.DriverHelper;

import java.sql.SQLException;

public class DBFieldTypeConverter {
    public static void main(String[] args) throws SQLException {
//        DriverHelper driverHelper = new MysqlHelper("192.168.1.150:3305", "datax_test", "root", "951753", null);
//        DriverHelper driverHelper = new OracleHelper("192.168.1.150:1521", "helowin", "test", "test", null);
//        DriverHelper driverHelper = new SqlserverHelper("192.168.1.150:1433", "master", "SA", "Zhjl.sqlserver", null);
//        DriverHelper driverHelper = new PostgresqlHelper("192.168.1.150:15432", "jdragon", "jdragon", "Zhjl.postgres", null);
//        DriverHelper driverHelper = new DMHelper("192.168.1.150:30236", "testdb", "SYSDBA", "SYSDBA", null);
        DriverHelper driverHelper = new GaussDBHelper("10.194.186.223:11432", "postgres", "gaussdb", "Gauss@123", null);
        driverHelper.createFullTypeTable();
        driverHelper.printFullType();
    }

}