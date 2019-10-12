package com.x5a.assetsystem.page.pegawai;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Pegawai;

public class PegawaiDelete extends PageBase {
    PageBase returnPage;

    public PegawaiDelete(PageBase return_page) {
        this.returnPage = return_page;
    }

    @Override
    public PageBase getResult() {
        return this.returnPage;
    }

    @Override
    public void display() {
        Pegawai orm = new Pegawai();

        try {
            printLine();
            print("Masukkan ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Pegawai result = orm.Find(id);

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
