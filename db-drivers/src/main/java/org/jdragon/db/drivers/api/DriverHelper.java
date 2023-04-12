package org.jdragon.db.drivers.api;

import org.jdragon.db.drivers.SQLTypesMap;
import org.jdragon.db.drivers.SourcesEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Map;
import java.util.Set;


public abstract class DriverHelper implements DBOperation {

    private final Logger logger = LoggerFactory.getLogger(DriverHelper.class);

    private final String address;

    private final String database;

    private final String username;

    private final String password;

    private final Map<String, String> otherParameter;

    @Override
    public void printFullType() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from full_type where 1=2");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.printf("%30s%30s%30s%30s%n", "column_name", "JAVA_type", "DB_type", "SQL_type");
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            String columnClassName = metaData.getColumnClassName(i);
            String columnTypeName = metaData.getColumnTypeName(i);
            int columnType = metaData.getColumnType(i);
            String format = String.format("%30s%30s%30s%30s", columnName, columnClassName, columnTypeName, SQLTypesMap.get(columnType));
            System.out.println(format);
        }
    }

    public DriverHelper(String address, String database, String username, String password, Map<String, String> otherParameter) {
        this.address = address;
        this.database = database;
        this.username = username;
        this.password = password;
        this.otherParameter = otherParameter;
    }

    public Connection getConnection() {
        try {
            Class.forName(getDriver());
            String joinJdbcUrl = joinJdbcUrl(address, database, otherParameter);
            logger.info("jdbc url:{}", joinJdbcUrl);
            return DriverManager.getConnection(joinJdbcUrl(address, database, otherParameter), username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String joinJdbcUrl(String address, String database, Map<String, String> otherParameter) {
        String result = String.format(getJdbc(), address, database);
        if (otherParameter != null && otherParameter.size() > 0) {
            Set<String> keys = otherParameter.keySet();
            StringBuilder str = new StringBuilder();
            for (String key : keys) {
                str.append(String.format("%s=%s%s", key, otherParameter.get(key), getSeparator()));
            }
            str.deleteCharAt(str.length() - 1);
            result += getExtraParameterStart() + str;
        }
        return result;
    }

    public void exec(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        logger.info("exec sql:{}", sql);
        boolean execute = statement.execute(sql);
        logger.info("exec result:{}", execute);
        connection.close();
    }

    @Override
    public void createFullTypeTable() throws SQLException {
        String fullTypeCreateSql = getFullTypeCreateSql();
        exec(fullTypeCreateSql);
    }

    public SourcesEnum getType() {
        throw new RuntimeException("未指定type");
    }

    /**
     * 获取驱动
     *
     * @return {@link String}
     */
    public String getDriver() {
        throw new RuntimeException("未指定driver");
    }

    /**
     * 获取jdbc url规则
     *
     * @return {@link String}
     */
    public abstract String getJdbc();

    public String getExtraParameterStart() {
        return "?";
    }

    public String getSeparator() {
        return "&";
    }

}