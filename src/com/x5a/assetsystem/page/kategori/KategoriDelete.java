package com.x5a.assetsystem.page.kategori;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Kategori;

public class KategoriDelete extends PageBase {
    PageBase returnPage;

    public KategoriDelete(PageBase return_page) {
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

            print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                println("Berhasil menghapus data");
                result.Delete();
            }
        } catch (Exception ex) {
            println("Gagal menghapus data");
        }
    }
}