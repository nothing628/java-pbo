package com.x5a.assetsystem.page.kategori;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

import java.util.ArrayList;

import com.x5a.assetsystem.database.Kategori;

public class KategoriIndex extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new KategoriNew(this);
            case "2":
                return new KategoriEdit(this);
            case "3":
                return new KategoriDelete(this);
            case "4":
                return new MainPage();
            default:
                return this;
        }
    }

    @Override
    public void display() {
        Kategori kategori = new Kategori();
        ArrayList<Kategori> list_kategori = kategori.Select();

        printLine();

        for (Kategori item : list_kategori) {
            print("| " + item.id + " ");
            println("| " + item.nama_kategori + " |");
        }

        printLine();
        println("1. Kategori Baru | 2. Edit Kategori | 3. Hapus Kategori | 4. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}