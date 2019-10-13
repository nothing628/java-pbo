package com.x5a.assetsystem.page.assetdetail;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.page.PageBase;

public class AssetDetailNew extends PageBase {

	PageBase returnPage;
	Asset asset;

    public AssetDetailNew(PageBase return_page, Asset asset) {
        this.returnPage = return_page;
        this.asset = asset;
    }
    
	@Override
	public PageBase getResult() {
		return returnPage;
	}

	@Override
	public void display() {
		AssetDetail orm = new AssetDetail();
		
		try {
			printLine();
			print("Lokasi Asset      : ");
			orm.lokasi = scanner.nextLine();
			print("Pemegang Asset    : ");
			orm.pegawai = scanner.nextLine();
			print("Kondisi           : ");
			orm.kondisi = scanner.nextLine();
			orm.id_asset = asset.id;
			
			orm.Insert();
			println("Berhasil menambahkan data");
		} catch (Exception ex) {
			println("Gagal menambahkan");
		}
	}

}
