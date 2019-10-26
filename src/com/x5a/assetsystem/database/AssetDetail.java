package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AssetDetail extends DBBase {
    public int id;
    public int id_asset;
    public String lokasi;
    public String pegawai;
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
    public AssetDetail Find(int id) {
        ArrayList<AssetDetail> result = Select(String.format("%s = %d", getPrimaryKeyField(), id));

        return result.get(0);   //Just get first element
    }

    @Override
    protected AssetDetail MapFromResultSet(ResultSet result) throws SQLException {
        AssetDetail item = new AssetDetail();

        item.id = result.getInt("id");
        item.id_asset = result.getInt("id_asset");
        item.lokasi = result.getString("lokasi");
        item.pegawai = result.getString("pegawai");
        item.kondisi = result.getString("kondisi");

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
        try {
        	int id_lanjutan = getLatestId() + 1;
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            String query = String.format(
                "INSERT INTO %s (id, id_asset, lokasi, pegawai, kondisi) VALUES (%d, %d, '%s', '%s', '%s')",
                nama_table,
                id_lanjutan,
                this.id_asset,
                this.lokasi,
                this.pegawai,
                this.kondisi
            );
            
            this.id = id_lanjutan;

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
                "UPDATE %s SET id_asset = %d, lokasi = '%s', pegawai = '%s', kondisi = '%s' WHERE %s = %d",
                nama_table,
                this.id_asset,
                this.lokasi,
                this.pegawai,
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