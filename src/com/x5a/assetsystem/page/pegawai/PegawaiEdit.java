package com.x5a.assetsystem.page.pegawai;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.Pegawai;

public class PegawaiEdit extends PageBase {
    PageBase returnPage;

    public PegawaiEdit(PageBase return_page) {
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

            print("Nama Pegawai      : ");
            result.nama_pegawai = scanner.nextLine();
            print("Lantai            : ");
            result.jenis_kelamin = scanner.nextLine();
            print("Jabatan           : ");
            result.jabatan = scanner.nextLine();

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
