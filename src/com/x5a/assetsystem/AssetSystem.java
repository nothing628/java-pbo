package com.x5a.assetsystem;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

public class AssetSystem {

	public static void main(String[] args) {
		PageBase page = new MainPage();
		PageBase result_page = null;

		do {
			try {
				page.display();
				result_page = page.getResult();

				page = result_page;
			} catch (Exception ex) {
				result_page = null;
				ex.printStackTrace();
			}
		} while (result_page != null);
	}
}
