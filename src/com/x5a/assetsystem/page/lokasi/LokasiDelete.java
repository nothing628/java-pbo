package com.x5a.assetsystem.page.lokasi;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Lokasi;

public class LokasiDelete extends PageBase {
    PageBase returnPage;

    public LokasiDelete(PageBase return_page) {
        this.returnPage = return_page;
    }

    @Override
    public PageBase getResult() {
        return this.returnPage;
    }

    @Override
    public void display() {
        Lokasi orm = new Lokasi();

        try {
            printLine();
            print("Masukkan ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Lokasi result = orm.Find(id);

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
