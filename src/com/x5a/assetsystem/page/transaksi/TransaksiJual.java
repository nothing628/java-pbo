package com.x5a.assetsystem.page.transaksi;

import com.x5a.assetsystem.page.PageBase;

public class TransaksiJual extends PageBase {

	PageBase returnPage;

    public TransaksiJual(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getResult() {
		return returnPage;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
