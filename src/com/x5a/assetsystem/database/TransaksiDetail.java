package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransaksiDetail extends DBBase {
    public int id;
    public int id_transaksi;
    public int id_asset_detail;
    public int harga;

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
        return "transaksi_detail";
    }

    @Override
    public ArrayList<TransaksiDetail> Select() {
        return Select("1=1");
    }

    @Override
    public TransaksiDetail Find(int id) {
        ArrayList<TransaksiDetail> result = Select(String.format("%s = %d", getPrimaryKeyField(), id));

        return result.get(0);   //Just get first element
    }

    @Override
    protected TransaksiDetail MapFromResultSet(ResultSet result) throws SQLException {
        TransaksiDetail item = new TransaksiDetail();

        item.id = result.getInt("id");
        item.id_transaksi = result.getInt("id_transaksi");
        item.id_asset_detail = result.getInt("id_asset_detail");
        item.harga = result.getInt("harga");

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
    public ArrayList<TransaksiDetail> Select(String where) {
        ArrayList<TransaksiDetail> list = new ArrayList<TransaksiDetail>();

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
                "INSERT INTO %s (id, id_transaksi, id_asset_detail, harga) VALUES (%d, %d, %d, %d)",
                nama_table,
                getLatestId() + 1,
                this.id_transaksi,
                this.id_asset_detail,
                this.harga
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
                "UPDATE %s SET id_transaksi = %d, id_asset_detail = %d, harga = %d WHERE %s = %d",
                nama_table,
                this.id_transaksi,
                this.id_asset_detail,
                this.harga,
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