package com.x5a.assetsystem.page.laporan;

import com.x5a.assetsystem.page.PageBase;

public class LaporanIndex extends PageBase {

	PageBase returnPage;
	String result;

    public LaporanIndex(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		switch (result) {
			case "0":
				return returnPage;
			case "1":
				return new LaporanAsset(this);
			case "2":
				return new LaporanTransaksi(this);
			default:
				return this;
		}
	}

	@Override
	public void display() {
		printLine();
        println("1. Laporan Asset");
        println("2. Laporan Transaksi");
        println();
        println("0. Back");
        print("Choose number : ");

        result = scanner.nextLine();
	}

}
