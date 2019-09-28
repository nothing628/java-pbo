package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kategori extends DBBase<Kategori> {
    public int id;
    public String nama_kategori;

    @Override
    public void constructor() {
        super.constructor();
    }

    @Override
    protected String getPrimaryKeyField() {
        return "id";
    }

    @Override
    protected String getTableName() {
        return "kategori";
    }

    @Override
    public ArrayList<Kategori> Select() {
        return Select("1=1");
    }

    @Override
    protected Kategori MapFromResultSet(ResultSet result) throws SQLException {
        Kategori user = new Kategori();

        user.id = result.getInt("id");
        user.nama_kategori = result.getString("nama_kategori");

        return user;
    }

    @Override
    public ArrayList<Kategori> Select(String where) {
        ArrayList<Kategori> list = new ArrayList<Kategori>();

        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + nama_table + " WHERE " + where);

            while(result.next()) {
                list.add(MapFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int Insert() {
        // TODO Auto-generated method stub
        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = "INSERT INTO " + nama_table +
            "(id, nama_kategori) VALUES (" +
            this.id + ", '" + this.nama_kategori + "')";

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public int Update() {
        // TODO Auto-generated method stub
        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = "UPDATE " + nama_table +
            " SET nama_kategori = '" + this.nama_kategori +
            "' WHERE id = " + this.id;

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public int Delete() {
        // TODO Auto-generated method stub
        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = "DELETE FROM " + nama_table +
            " WHERE id = " + this.id;

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}