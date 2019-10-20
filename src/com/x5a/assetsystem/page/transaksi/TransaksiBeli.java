package com.x5a.assetsystem.page.transaksi;

import java.util.ArrayList;
import java.util.Date;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.database.Transaksi;
import com.x5a.assetsystem.database.TransaksiDetail;
import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.AssetSystem;

public class TransaksiBeli extends PageBase {

	PageBase returnPage;

    public TransaksiBeli(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		return returnPage;
	}

	@Override
	public void display() {
		Asset orm = new Asset();
		Transaksi orm_transaksi = new Transaksi();
		TransaksiDetail orm_detail = new TransaksiDetail();
		
		try {
			ArrayList<Asset> list_asset = orm.Select();
			
			printLine();
			println("Daftar Asset");
			for (Asset item : list_asset) {
				println(String.format("| %2s | %20s | %12s | %10s |", item.id, item.nama_asset, item.kategori, item.jenis));
	        }
			
			printLine();
			print("Masukkan ID Asset yg akan dibeli : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			Asset result = orm.Find(id);
			
			print("Penjual  : ");
			orm_transaksi.penjual = scanner.nextLine();
			orm_transaksi.penerima = AssetSystem.NamaPerusahaan;
			print("Harga    : ");
			int harga = scanner.nextInt();
			scanner.nextLine();
			
			orm_transaksi.tgl_transaksi = (new Date()).toString();
			orm_transaksi.jenis = "Beli";
			orm_transaksi.Insert();
			
			AssetDetail detail = InsertAssetDetail(result.id);
			
			orm_detail.id_asset_detail = detail.id;
			orm_detail.id_transaksi = orm_transaksi.id;
			orm_detail.harga = harga;
			orm_detail.Insert();
		} catch (Exception e) {
			println("Gagal melakukan transaksi");
		}
	}

	private AssetDetail InsertAssetDetail(int id_asset) {
		AssetDetail orm = new AssetDetail();
		orm.id_asset = id_asset;
		orm.kondisi = "Baik";
		orm.lokasi = "Gudang";
		orm.pegawai = "";
		orm.Insert();
		
		return orm;
	}
}
