package com.x5a.assetsystem.page.asset;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

public class AssetIndex extends PageBase {
	String result;

    @Override
    public PageBase getResult() {
    	switch (result) {
	        case "1":
	            return new AssetNew(this);
	        case "2":
	            return new AssetEdit(this);
	        case "3":
	            return new AssetDelete(this);
	        case "4":
	        	return new AssetDetail(this);
	        case "5":
	            return new MainPage();
	        default:
	            return this;
	    }
    }

    @Override
    public void display() {
        print("Main page");

        printLine();
        println("1. Asset Baru | 2. Edit Asset | 3. Hapus Asset | 4. Detail Asset | 5. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}