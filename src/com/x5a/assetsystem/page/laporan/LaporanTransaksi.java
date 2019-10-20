package com.x5a.assetsystem.page.laporan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.x5a.assetsystem.database.DBConnection;
import com.x5a.assetsystem.page.PageBase;

public class LaporanTransaksi extends PageBase {

	PageBase returnPage;

    public LaporanTransaksi(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		return returnPage;
	}

	@Override
	public void display() {
		try {
			Statement stat = DBConnection.connection.createStatement();
			ResultSet set = stat.executeQuery("SELECT * FROM transaksi "
					+ "JOIN transaksi_detail ON transaksi.id = transaksi_detail.id_transaksi "
					+ "JOIN asset_detail ON asset_detail.id = transaksi_detail.id_asset_detail "
					+ "JOIN asset ON asset_detail.id_asset = asset.id");
			
			printLine();
			while (set.next()) {
				String row_table = String.format(
						"| %20s | %15s | %20s | %10s | %15s | %10s | %6s |",
						set.getString("tgl_transaksi"),
						set.getString("jenis"),
						set.getString("nama_asset"),
						set.getString("penerima"),
						set.getString("penjual"),
						set.getString("harga"),
						set.getString("jenis"));

				println(row_table);
			}
		} catch (SQLException e) {
			println("Error: Tidak bisa menampilkan data");
		}
	}

}
