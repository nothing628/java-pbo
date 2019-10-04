package com.x5a.assetsystem;

import java.util.ArrayList;

import com.x5a.assetsystem.database.Kategori;
import com.x5a.assetsystem.database.User;

public class AssetSystem {

	public static void main(String[] args) {
		Kategori kategori = new Kategori();
		// kategori.id = 2;
		// kategori.nama_kategori="Meja";
		// kategori.Insert();

		ArrayList<Kategori> result = kategori.Select();
		
		for (Kategori item : result) {
			// user.nama_kategori = user.nama_kategori + " selesai";
			// user.Update();
			System.out.println(item.id);
			System.out.println(item.nama_kategori);
		}
	}
}
