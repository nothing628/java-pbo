package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User extends DBBase<User> {
    public int id;
    public int id_pegawai;
    public String username;
    public String password;

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
        return "user";
    }

    @Override
    public ArrayList<User> Select() {
        return Select("1=1");
    }

    @Override
    protected User MapFromResultSet(ResultSet result) throws SQLException {
        User user = new User();

        user.id = result.getInt("id");
        user.id_pegawai = result.getInt("id_pegawai");
        user.username = result.getString("username");
        user.password = result.getString("password");

        return user;
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
    public ArrayList<User> Select(String where) {
        ArrayList<User> list = new ArrayList<User>();

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
                "INSERT INTO %s (id, id_pegawai, username, password) VALUES (%d, %d, '%s', '%s')",
                nama_table,
                this.id,
                this.id_pegawai,
                this.username,
                this.password
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
                "UPDATE %s SET id_pegawai = %d, username = '%s', password = '%s' WHERE %s = %d",
                nama_table,
                this.id_pegawai,
                this.username,
                this.password,
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