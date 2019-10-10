package com.x5a.assetsystem.page.pegawai;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Pegawai;
import java.util.ArrayList;

public class PegawaiIndex extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new PegawaiNew(this);
            case "2":
                return new PegawaiEdit(this);
            case "3":
                return new PegawaiDelete(this);
            case "4":
                return new MainPage();
            default:
                return this;
        }
    }

    @Override
    public void display() {
        Pegawai data = new Pegawai();
        ArrayList<Pegawai> list_data = data.Select();

        printLine();

        for (Pegawai item : list_data) {
            print("| " + item.id + " ");
            print("| " + item.nama_pegawai + " ");
            print("| " + item.jenis_kelamin + " ");
            println("| " + item.jabatan + " |");
        }

        printLine();
        println("1. Pegawai Baru | 2. Edit Pegawai | 3. Hapus Pegawai | 4. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}
