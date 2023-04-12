package org.jdragon.db.drivers.api;

import java.sql.*;

public interface DBOperation {

    void printFullType() throws SQLException;

    String getFullTypeCreateSql();

    void createFullTypeTable() throws SQLException;

}
