package com.x5a.assetsystem.page.laporan;

import com.x5a.assetsystem.page.PageBase;

public class LaporanTransaksi extends PageBase {

	PageBase returnPage;

    public LaporanTransaksi(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		return returnPage;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
