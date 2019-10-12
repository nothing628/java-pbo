package com.x5a.assetsystem.page.asset;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.page.PageBase;

public class AssetDetail extends PageBase {

	PageBase returnPage;
	String respon;

    public AssetDetail(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		switch (respon) {
		case "1":
		case "2":
		case "3":
		case "4":
			return returnPage;
		}
		
		return this;
	}

	@Override
	public void display() {
		Asset orm = new Asset();
		
		try {
			printLine();
			print("Masukkan ID       : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			Asset result = orm.Find(id);
			
			printLine();
			println("Data Saat ini :");
			println(String.format("Nama Asset        : %s", result.nama_asset));
			println(String.format("Kategori          : %s", result.kategori));
			println(String.format("Jenis             : %s", result.jenis));
			printLine();
			
			println("1. Barang Baru | 2. Edit Barang | 3. Barang Asset | 4. Kembali");
	        print("Choose number : ");
			respon = scanner.nextLine();
		} catch (Exception ex) {
			println("Gagal mengambil detail");
		}
	}

}
