package com.x5a.assetsystem.page.assetdetail;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.page.PageBase;

public class AssetDetailDelete extends PageBase {

	PageBase returnPage;
	Asset asset;

    public AssetDetailDelete(PageBase return_page, Asset asset) {
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
			println(String.format("Nama Asset        : %s", result.lokasi));
			println(String.format("Kategori          : %s", result.pegawai));
			println(String.format("Jenis             : %s", result.kondisi));
			
			printLine();
			print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                println("Berhasil menghapus data");
                result.Delete();
            }
		} catch (Exception ex) {
			println("Gagal menghapus");
		}
	}

}
