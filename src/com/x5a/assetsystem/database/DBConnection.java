package com.x5a.assetsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection;

    static {
        try {
			Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:/test.db");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.print("Gagal konek" + e.getMessage());
		}
    }
}