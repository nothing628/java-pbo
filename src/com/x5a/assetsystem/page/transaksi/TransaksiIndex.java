package com.x5a.assetsystem.page.transaksi;

import com.x5a.assetsystem.page.PageBase;

public class TransaksiIndex extends PageBase {

	String result;
	PageBase returnPage;

    public TransaksiIndex(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		switch (result) {
			case "1":
				return new TransaksiBeli(this);
			case "2":
				return new TransaksiJual(this);
			case "0":
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
        println();
        println("0. Back");
        print("Choose number : ");

        result = scanner.nextLine();
	}

}
