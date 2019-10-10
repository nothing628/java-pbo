package com.x5a.assetsystem.page.kategori;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Kategori;

public class KategoriNew extends PageBase {
    PageBase returnPage;

    public KategoriNew(PageBase return_page) {
        this.returnPage = return_page;
    }

    @Override
    public PageBase getResult() {
        return returnPage;
    }

    @Override
    public void display() {
        Kategori kategori = new Kategori();

        try {
            printLine();
            print("Nama Kategori     : ");
            kategori.nama_kategori = scanner.nextLine();

            print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                kategori.Insert();
                println("Berhasil menambahkan");
            }
        } catch (Exception ex) {
            println("Gagal menambahkan");
        }
    }
}