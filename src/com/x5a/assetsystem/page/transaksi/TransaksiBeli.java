package com.x5a.assetsystem.page.transaksi;

import com.x5a.assetsystem.page.PageBase;

public class TransaksiBeli extends PageBase {

	PageBase returnPage;

    public TransaksiBeli(PageBase return_page) {
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