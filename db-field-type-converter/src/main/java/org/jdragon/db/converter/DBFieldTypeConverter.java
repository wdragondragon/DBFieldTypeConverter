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
//        DriverHelper driverHelper = new GaussDBHelper("10.194.186.223:11432", "postgres", "gaussdb", "Gauss@123", null);
//        DriverHelper driverHelper = new ClickHouseHelper("192.168.1.150:18123", "my_database", "test", "test", null);
//        DriverHelper driverHelper = new DB2Helper("192.168.1.150:50000", "testdb", "db2inst1", "db2@123", null);
//        DriverHelper driverHelper = new HiveHelper("192.168.1.161:10000", "test", "", "", null);
//        DriverHelper driverHelper = new HanaHelper("192.168.228.128:39013", "admin", "admin", "Cbw123456", null);
//        DriverHelper driverHelper = new TeradataHelper("115.236.153.170", "41045","test", "dbc", "dbc", null);
        DriverHelper driverHelper = new Gbase8aHelper("115.236.153.170:50186", "test", "gbase", "gbase20110531", null);
        driverHelper.createFullTypeTable();
        driverHelper.printFullType();
    }

}