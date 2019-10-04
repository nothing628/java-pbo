package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AssetDetail extends DBBase<AssetDetail> {
    public int id;
    public int id_asset;
    public int id_lokasi;
    public int id_pegawai;
    public String kondisi;

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
        return "asset_detail";
    }

    @Override
    public ArrayList<AssetDetail> Select() {
        return Select("1=1");
    }

    @Override
    protected AssetDetail MapFromResultSet(ResultSet result) throws SQLException {
        AssetDetail item = new AssetDetail();

        item.id = result.getInt("id");
        item.id_asset = result.getInt("id_asset");
        item.id_lokasi = result.getInt("id_lokasi");
        item.id_pegawai = result.getInt("id_pegawai");
        item.kondisi = result.getString("kondisi");

        return item;
    }

    @Override
    public ArrayList<AssetDetail> Select(String where) {
        ArrayList<AssetDetail> list = new ArrayList<AssetDetail>();

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
                "INSERT INTO %s (id, id_asset, id_lokasi, id_pegawai, kondisi) VALUES (%d, %d, %d, %d, '%s')",
                nama_table,
                this.id,
                this.id_asset,
                this.id_lokasi,
                this.id_pegawai,
                this.kondisi
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
                "UPDATE %s SET id_asset = %d, id_lokasi = %d, id_pegawai = %d, kondisi = '%s' WHERE %s = %d",
                nama_table,
                this.id_asset,
                this.id_lokasi,
                this.id_pegawai,
                this.kondisi,
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