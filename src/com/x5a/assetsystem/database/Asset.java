package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Asset extends DBBase<Asset> {
    public int id;
    public int id_kategori;
    public String nama_asset;
    public String jenis;

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
        return "asset";
    }

    @Override
    public ArrayList<Asset> Select() {
        return Select("1=1");
    }

    @Override
    public Asset Find(int id) {
        ArrayList<Asset> result = Select(String.format("%s = %d", getPrimaryKeyField(), id));

        return result.get(0);   //Just get first element
    }

    @Override
    protected Asset MapFromResultSet(ResultSet result) throws SQLException {
        Asset item = new Asset();

        item.id = result.getInt("id");
        item.id_kategori = result.getInt("id_kategori");
        item.nama_asset = result.getString("nama_asset");
        item.jenis = result.getString("jenis");

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
    public ArrayList<Asset> Select(String where) {
        ArrayList<Asset> list = new ArrayList<Asset>();

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
                "INSERT INTO %s (id, id_kategori, nama_asset, jenis) VALUES (%d, %d, '%s', '%s')",
                nama_table,
                this.id,
                this.id_kategori,
                this.nama_asset,
                this.jenis
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
                "UPDATE %s SET id_kategori = %d, nama_asset = '%s', jenis = '%s' WHERE %s = %d",
                nama_table,
                this.id_kategori,
                this.nama_asset,
                this.jenis,
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