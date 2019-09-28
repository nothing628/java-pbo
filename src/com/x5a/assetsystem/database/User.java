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
    public ArrayList<User> Select(String where) {
        ArrayList<User> list = new ArrayList<User>();

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
            "(id, id_pegawai, username, password) VALUES (" +
            this.id + ", " + this.id_pegawai + ", '" + this.username + "', '" + this.password + "')";

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
            " SET id_pegawai = " + this.id_pegawai +
            ", username = '" + this.username + "'" +
            ", password = '" + this.password + "'" +
            " WHERE id = " + this.id;

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
            String query = "DELTE FROM " + nama_table +
            " WHERE id = " + this.id;

            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}