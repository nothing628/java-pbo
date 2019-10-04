package com.x5a.assetsystem.page.kategori;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

public class KategoriIndex extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
            case "2":
                return this;
            case "3":
                return new MainPage();
            default:
                return this;
        }
    }

    @Override
    public void display() {
        System.out.println("Kategori Index :");
        System.out.println("1. Buat Kategori");
        System.out.println("2. Daftar Kategori");
        System.out.println("3. Kembali");
        System.out.print("Choose number : ");

        result = scanner.nextLine();
    }
}