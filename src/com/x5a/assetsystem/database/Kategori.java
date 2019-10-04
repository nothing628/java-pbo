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
            String query = String.format("SELECT * FROM %s WHERE %s", nama_table, where);
            ResultSet result = statement.executeQuery(query);

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
            String query = String.format(
                "INSERT INTO %s (id, nama_kategori) VALUES (%d, '%s')",
                nama_table,
                this.id,
                this.nama_kategori
            );

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
            String query = String.format(
                "UPDATE %s SET nama_kategori = '%s' WHERE %s = %d",
                nama_table,
                this.nama_kategori,
                getPrimaryKeyField(),
                this.id
            );

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
            String query = String.format(
                "DELETE FROM %s WHERE %s = %d",
                nama_table,
                getPrimaryKeyField(),
                this.id
            );

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}