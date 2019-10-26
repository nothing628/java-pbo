package com.x5a.assetsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DBBase {
    /**
     * Nama tabel yang mewakili object class
     * 
     * @return String
     */
    protected abstract int getLatestId();
    protected abstract String getTableName();
    protected abstract DBBase MapFromResultSet(ResultSet result) throws SQLException;
    public abstract DBBase Find(int id);
    public abstract List<?> Select();
    public abstract List<?> Select(String where);
    public abstract int Insert();
    public abstract int Update();
    public abstract int Delete();

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