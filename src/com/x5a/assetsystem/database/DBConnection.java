package com.x5a.assetsystem.database;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            String location = getDbFileLocation();
            connection = DriverManager.getConnection("jdbc:sqlite:" + location);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.print("Gagal konek" + e.getMessage());
		}
    }

    public static String getDbFileLocation() {
        Path path = Paths.get("asset_system.db");
        // return "E:/test.db";
        return path.toAbsolutePath().normalize().toString();
    }
}