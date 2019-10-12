package com.x5a.assetsystem.page.user;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.User;

public class UserNew extends PageBase {
    PageBase returnPage;

    public UserNew(PageBase return_page) {
        this.returnPage = return_page;
    }

    @Override
    public PageBase getResult() {
        return this.returnPage;
    }

    @Override
    public void display() {
        User orm = new User();

        try {
            printLine();
            print("Username          : ");
            orm.username = scanner.nextLine();
            print("Password          : ");
            orm.password = scanner.nextLine();
            print("ID Pegawai        : ");
            orm.id_pegawai = scanner.nextInt();
            scanner.nextLine();

            print("Anda yakin? (Y/N) : ");
            String yakin = scanner.nextLine();

            if (yakin.equalsIgnoreCase("Y")) {
                orm.Insert();
                println("Berhasil menambahkan");
            }
        } catch (Exception ex) {
            println("Gagal menambahkan");
        }
    }
}
