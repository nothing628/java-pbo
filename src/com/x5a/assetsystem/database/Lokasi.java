package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Lokasi extends DBBase<Lokasi> {
    public int id;
    public String nama_ruang;
    public String lantai;

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
        return "lokasi";
    }

    @Override
    public ArrayList<Lokasi> Select() {
        return Select("1=1");
    }

    @Override
    public Lokasi Find(int id) {
        ArrayList<Lokasi> result = Select(String.format("%s = %d", getPrimaryKeyField(), id));

        return result.get(0);   //Just get first element
    }

    @Override
    protected Lokasi MapFromResultSet(ResultSet result) throws SQLException {
        Lokasi item = new Lokasi();

        item.id = result.getInt("id");
        item.nama_ruang = result.getString("nama_ruang");
        item.lantai = result.getString("lantai");

        return item;
    }

    @Override
    protected int getLatestId() {
        int result = 1;

        try {
            String nama_table = this.getTableName();
            String kolom_primary = this.getPrimaryKeyField();
            Statement statement = this.getConnection().createStatement();
            String query = String.format("SELECT MAX(%s) as %s FROM %s", kolom_primary, kolom_primary, nama_table);
            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                result = resultset.getInt(kolom_primary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ArrayList<Lokasi> Select(String where) {
        ArrayList<Lokasi> list = new ArrayList<Lokasi>();

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
        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = String.format(
                "INSERT INTO %s (id, nama_ruang, lantai) VALUES (%d, '%s', '%s')",
                nama_table,
                this.id,
                this.nama_ruang,
                this.lantai
            );

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public int Update() {
        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = String.format(
                "UPDATE %s SET nama_ruang = '%s', lantai = '%s' WHERE %s = %d",
                nama_table,
                this.nama_ruang,
                this.lantai,
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