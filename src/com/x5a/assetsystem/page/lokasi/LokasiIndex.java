package com.x5a.assetsystem.page.lokasi;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Lokasi;
import java.util.ArrayList;

public class LokasiIndex extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new LokasiNew(this);
            case "2":
                return new LokasiEdit(this);
            case "3":
                return new LokasiDelete(this);
            case "4":
                return new MainPage();
            default:
                return this;
        }
    }

    @Override
    public void display() {
        Lokasi data = new Lokasi();
        ArrayList<Lokasi> list_data = data.Select();

        printLine();

        for (Lokasi item : list_data) {
            print("| " + item.id + " ");
            print("| " + item.nama_ruang + " ");
            println("| " + item.lantai + " |");
        }

        printLine();
        println("1. Lokasi Baru | 2. Edit Lokasi | 3. Hapus Lokasi | 4. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}
