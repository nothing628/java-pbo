package com.x5a.assetsystem.page.laporan;

import com.x5a.assetsystem.page.PageBase;

public class LaporanAsset extends PageBase {

	PageBase returnPage;

    public LaporanAsset(PageBase return_page) {
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
