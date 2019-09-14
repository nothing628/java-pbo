package com.x5a.assetsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User extends DBBase<User> {
    public int Coba;

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
        ArrayList<User> list = new ArrayList<User>();

        try {
            String nama_table = this.getTableName();
            Statement statement = this.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + nama_table);

            while(result.next()) {
                list.add(MapFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected User MapFromResultSet(ResultSet result) throws SQLException {
        User user = new User();

        user.Coba = result.getInt("Coba");

        return user;
    }
}