package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pegawai extends DBBase<Pegawai> {
    public int id;
    public String nama_pegawai;
    public String jenis_kelamin;
    public String jabatan;

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
        return "pegawai";
    }

    @Override
    public ArrayList<Pegawai> Select() {
        return Select("1=1");
    }

    @Override
    protected Pegawai MapFromResultSet(ResultSet result) throws SQLException {
        Pegawai item = new Pegawai();

        item.id = result.getInt("id");
        item.nama_pegawai = result.getString("nama_pegawai");
        item.jenis_kelamin = result.getString("jenis_kelamin");
        item.jabatan = result.getString("jabatan");

        return item;
    }

    @Override
    public ArrayList<Pegawai> Select(String where) {
        ArrayList<Pegawai> list = new ArrayList<Pegawai>();

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
                "INSERT INTO %s (id, nama_pegawai, jenis_kelamin, jabatan) VALUES (%d, '%s', '%s', '%s')",
                nama_table,
                this.id,
                this.nama_pegawai,
                this.jenis_kelamin,
                this.jabatan
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
                "UPDATE %s SET nama_pegawai = '%s', jenis_kelamin = '%s', jabatan = '%s' WHERE %s = %d",
                nama_table,
                this.nama_pegawai,
                this.jenis_kelamin,
                this.jabatan,
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