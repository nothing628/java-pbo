package com.x5a.assetsystem.page.laporan;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaporanAsset extends PageBase {

	PageBase returnPage;

    public LaporanAsset(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		return returnPage;
	}

	@Override
	public void display() {
		try {
			Statement stat = DBConnection.connection.createStatement();
			ResultSet set = stat.executeQuery("SELECT * FROM asset "
					+ "JOIN asset_detail ON asset.id = asset_detail.id_asset");
			
			printLine();
			while (set.next()) {
				String row_table = String.format(
						"| %20s | %15s | %10s | %10s | %10s | %6s |",
						set.getString("nama_asset"),
						set.getString("kategori"),
						set.getString("jenis"),
						set.getString("lokasi"),
						set.getString("pegawai"),
						set.getString("kondisi"));

				println(row_table);
			}
		} catch (SQLException e) {
			println("Error: Tidak bisa menampilkan data");
		}
	}

}
