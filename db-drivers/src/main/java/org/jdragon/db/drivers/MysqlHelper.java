package org.jdragon.db.drivers;

import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;



public class MysqlHelper extends DriverHelper {

    public MysqlHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        super(address, database, username, password, otherParameter);
    }

    @Override
    public String getJdbc() {
        return "jdbc:mysql://%s/%s";
    }

    @Override
    public String getDriver() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public SourcesEnum getType() {
        return SourcesEnum.mysql;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE TABLE IF NOT EXISTS `full_type` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `t_tinyint` tinyint(255) DEFAULT NULL,\n" +
                "  `t_mediumint` mediumint(255) DEFAULT NULL,\n" +
                "  `t_integer` int(255) DEFAULT NULL,\n" +
                "  `t_bigint` bigint(255) DEFAULT NULL,\n" +
                "  `t_float` float DEFAULT NULL,\n" +
                "  `t_double` double DEFAULT NULL,\n" +
                "  `t_decimal` decimal(10,2) DEFAULT NULL,\n" +
                "  `t_date` date DEFAULT NULL,\n" +
                "  `t_time` time DEFAULT NULL,\n" +
                "  `t_year` year(4) DEFAULT NULL,\n" +
                "  `t_datetime` datetime DEFAULT NULL,\n" +
                "  `t_timestamp` timestamp NULL DEFAULT NULL,\n" +
                "  `t_varchar` varchar(255) DEFAULT NULL,\n" +
                "  `t_char` char(255) DEFAULT NULL,\n" +
                "  `t_tinyblob` tinyblob,\n" +
                "  `t_tinytext` tinytext,\n" +
                "  `t_blob` blob,\n" +
                "  `t_mediumblob` mediumblob,\n" +
                "  `t_mediumtext` mediumtext,\n" +
                "  `t_text` text,\n" +
                "  `t_longblob` longblob,\n" +
                "  `t_longtext` longtext,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
    }
}
