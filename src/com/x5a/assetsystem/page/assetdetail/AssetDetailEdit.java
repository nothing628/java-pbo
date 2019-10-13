package com.x5a.assetsystem.page.assetdetail;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.page.PageBase;

public class AssetDetailEdit extends PageBase {

	PageBase returnPage;
	Asset asset;

    public AssetDetailEdit(PageBase return_page, Asset asset) {
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
			print("Masukkan ID       : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			AssetDetail result = orm.Find(id);
			
			printLine();
			println("Data Saat ini :");
			println(String.format("Lokasi Asset      : %s", result.lokasi));
			println(String.format("Pemegang Asset    : %s", result.pegawai));
			println(String.format("Kondisi           : %s", result.kondisi));
			
			printLine();
			print("Lokasi Asset      : ");
			result.lokasi = scanner.nextLine();
			print("Pemegang Asset    : ");
			result.pegawai = scanner.nextLine();
			print("Kondisi           : ");
			result.kondisi = scanner.nextLine();
			
			printLine();
			print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                println("Berhasil mengupdate data");
                result.Update();
            }
		} catch (Exception ex) {
			println("Gagal menambahkan");
		}
	}

}
