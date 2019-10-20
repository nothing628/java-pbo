package com.x5a.assetsystem.page.asset;

import java.util.ArrayList;

import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.page.PageBase;

public class AssetIndex extends PageBase {
	String result;
	PageBase returnPage;
	
	public AssetIndex(PageBase returnPage) {
		this.returnPage = returnPage;
	}

    @Override
    public PageBase getNextPage() {
    	switch (result) {
	        case "1":
	            return new AssetNew(this);
	        case "2":
	            return new AssetEdit(this);
	        case "3":
	            return new AssetDelete(this);
	        case "4":
	        	return new AssetBarang(this);
	        case "5":
	            return this.returnPage;
	        default:
	            return this;
	    }
    }

    @Override
    public void display() {
    	Asset orm = new Asset();
    	ArrayList<Asset> list_asset = orm.Select();

        printLine();

        for (Asset item : list_asset) {
            print("| " + item.id + " ");
            print("| " + item.nama_asset + " ");
            print("| " + item.kategori + " ");
            println("| " + item.jenis + " |");
        }
    	
        printLine();
        println("1. Asset Baru | 2. Edit Asset | 3. Hapus Asset | 4. Data Barang | 5. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}