package com.x5a.assetsystem.page.lokasi;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Lokasi;

public class LokasiNew extends PageBase {
    PageBase returnPage;

    public LokasiNew(PageBase return_page) {
        this.returnPage = return_page;
    }

    @Override
    public PageBase getResult() {
        return this.returnPage;
    }

    @Override
    public void display() {
        Lokasi lokasi = new Lokasi();

        try {
            printLine();
            print("Nama Ruang        : ");
            lokasi.nama_ruang = scanner.nextLine();
            print("Lantai            : ");
            lokasi.lantai = scanner.nextLine();

            print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                lokasi.Insert();
                println("Berhasil menambahkan");
            }
        } catch (Exception ex) {
            println("Gagal menambahkan");
        }
    }
}
