package com.x5a.assetsystem.page;

import com.x5a.assetsystem.page.kategori.KategoriIndex;
import com.x5a.assetsystem.page.lokasi.LokasiIndex;
import com.x5a.assetsystem.page.pegawai.PegawaiIndex;
import com.x5a.assetsystem.page.user.UserIndex;

public class MainPage extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new MainPage();
            case "2":
                return new KategoriIndex();
            case "3":
                return new LokasiIndex();
            case "4":
                return new PegawaiIndex();
            case "5":
                return new UserIndex();
        }

        return null;
    }

    @Override
    public void display() {
        printLine();
        println("Main Menu :");
        println("1. Main Menu");
        println("2. Kategori");
        println("3. Lokasi");
        println("4. Pegawai");
        println("5. User");
        print("Choose number (any for exit): ");

        result = scanner.nextLine();
    }
}