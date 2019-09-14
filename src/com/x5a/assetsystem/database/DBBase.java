package com.x5a.assetsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DBBase<E> {
    /**
     * Nama tabel yang mewakili object class
     * 
     * @return String
     */
    protected abstract String getTableName();
    protected abstract E MapFromResultSet(ResultSet result) throws SQLException;
    public abstract ArrayList<E> Select();
    public abstract ArrayList<E> Select(String where);

    public void constructor() {

    }

    /**
     * Nama kolom yang digunakan sebagai primary key
     * 
     * @return String
     */
    protected String getPrimaryKeyField() {
        return "id";
    }

    protected Connection getConnection() {
        return DBConnection.connection;
    }

}