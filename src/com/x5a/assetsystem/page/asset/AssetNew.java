package com.x5a.assetsystem.page.asset;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Asset;

public class AssetNew extends PageBase {

	PageBase returnPage;

    public AssetNew(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		return returnPage;
	}

	@Override
	public void display() {
		Asset orm = new Asset();
		
		try {
			printLine();
			print("Nama Asset        : ");
			orm.nama_asset = scanner.nextLine();
			print("Kategori          : ");
			orm.kategori = scanner.nextLine();
			print("Jenis             : ");
			orm.jenis = scanner.nextLine();
			
			orm.Insert();
		} catch (Exception ex) {
			println("Gagal menambahkan");
		}
	}

}
