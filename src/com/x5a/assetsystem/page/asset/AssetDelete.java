package com.x5a.assetsystem.page.asset;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.page.PageBase;

public class AssetDelete extends PageBase {

	PageBase returnPage;

    public AssetDelete(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		return returnPage;
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
