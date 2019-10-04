package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Transaksi extends DBBase<Transaksi> {
    public int id;
    public String tgl_transaksi;
    public String jenis;
    public String penerima;
    public String penjual;

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
        return "transaksi";
    }

    @Override
    public ArrayList<Transaksi> Select() {
        return Select("1=1");
    }

    @Override
    protected Transaksi MapFromResultSet(ResultSet result) throws SQLException {
        Transaksi item = new Transaksi();

        item.id = result.getInt("id");
        item.tgl_transaksi = result.getString("tgl_transaksi");
        item.jenis = result.getString("jenis");
        item.penerima = result.getString("penerima");
        item.penjual = result.getString("penjual");

        return item;
    }

    @Override
    public ArrayList<Transaksi> Select(String where) {
        ArrayList<Transaksi> list = new ArrayList<Transaksi>();

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
                "INSERT INTO %s (id, tgl_transaksi, jenis, penerima, penjual) VALUES (%d, '%s', '%s', '%s', '%s')",
                nama_table,
                this.id,
                this.tgl_transaksi,
                this.jenis,
                this.penerima,
                this.penjual
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
                "UPDATE %s SET tgl_transaksi = '%s', jenis = '%s', penerima = '%s', penjual = '%s' WHERE %s = %d",
                nama_table,
                this.tgl_transaksi,
                this.jenis,
                this.penerima,
                this.penjual,
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