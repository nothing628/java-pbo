package com.x5a.assetsystem.page.transaksi;

import com.x5a.assetsystem.page.PageBase;

public class TransaksiIndex extends PageBase {

	String result;
	PageBase returnPage;

    public TransaksiIndex(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		switch (result) {
			case "1":
				return new TransaksiBeli(this);
			case "2":
				return new TransaksiJual(this);
			case "3":
				return returnPage;
			default:
				return this;
		}
	}

	@Override
	public void display() {
		printLine();
        println("1. Transkasi Beli");
        println("2. Transaksi Jual");
        println("3. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
	}

}
