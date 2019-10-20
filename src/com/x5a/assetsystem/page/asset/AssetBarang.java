package com.x5a.assetsystem.page.asset;

import java.util.ArrayList;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.page.assetdetail.AssetDetailDelete;
import com.x5a.assetsystem.page.assetdetail.AssetDetailEdit;
import com.x5a.assetsystem.page.assetdetail.AssetDetailNew;

public class AssetBarang extends PageBase {

	PageBase returnPage;
	String respon;
	Asset asset;

    public AssetBarang(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		switch (respon) {
		case "1":
			return new AssetDetailNew(this, asset);
		case "2":
			return new AssetDetailEdit(this, asset);
		case "3":
			return new AssetDetailDelete(this, asset);
		case "4":
			return returnPage;
		}
		
		return this;
	}

	@Override
	public void display() {
		Asset orm = new Asset();
		AssetDetail orm_detail = new AssetDetail();
		
		try {
			if (asset == null) {
				printLine();
				print("Masukkan ID       : ");
				int id = scanner.nextInt();
				scanner.nextLine();
				
				asset = orm.Find(id);
			}
			
			ArrayList<AssetDetail> list_detail = orm_detail.Select("id_asset = " + asset.id);
			
			printLine();
			println("Data Saat ini :");
			println(String.format("Nama Asset        : %s", asset.nama_asset));
			println(String.format("Kategori          : %s", asset.kategori));
			println(String.format("Jenis             : %s", asset.jenis));
			
			printLine();
			for (AssetDetail item : list_detail) {
				println(String.format("| %s | %s | %s | %s |", item.id, item.lokasi, item.pegawai, item.kondisi));
	        }
			
			printLine();
			println("1. Barang Baru | 2. Edit Barang | 3. Hapus Barang | 4. Kembali");
	        print("Choose number : ");
			respon = scanner.nextLine();
		} catch (Exception ex) {
			println("Gagal mengambil detail");
		}
	}

}
