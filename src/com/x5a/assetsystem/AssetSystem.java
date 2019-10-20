package com.x5a.assetsystem;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

public class AssetSystem {
	public final static String NamaPerusahaan = "PT. Maju Mundur Senang";

	public static void main(String[] args) {
		PageBase current_page = new MainPage();

		do {
			try {
				current_page.display();
				current_page = current_page.getNextPage();
			} catch (Exception ex) {
				current_page = null;
				ex.printStackTrace();
			}
		} while (current_page != null);
	}
}
