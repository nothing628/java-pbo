package com.x5a.assetsystem.page.kategori;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Kategori;

public class KategoriEdit extends PageBase {
    PageBase returnPage;

    public KategoriEdit(PageBase return_page) {
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

            print("Masukkan ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Kategori result = kategori.Find(id);

            print("Nama Kategori     : ");
            result.nama_kategori = scanner.nextLine();

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