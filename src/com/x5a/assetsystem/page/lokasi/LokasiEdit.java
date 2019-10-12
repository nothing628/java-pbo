package com.x5a.assetsystem.page.lokasi;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Lokasi;

public class LokasiEdit extends PageBase {
    PageBase returnPage;

    public LokasiEdit(PageBase return_page) {
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

            print("Masukkan ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Lokasi result = lokasi.Find(id);

            print("Nama Ruang        : ");
            result.nama_ruang = scanner.nextLine();
            print("Lantai            : ");
            result.lantai = scanner.nextLine();

            print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                result.Update();
            }
        } catch (Exception ex) {
            println("Gagal mengupdate");
        }
    }
}
