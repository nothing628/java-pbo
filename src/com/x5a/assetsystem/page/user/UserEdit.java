package com.x5a.assetsystem.page.user;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.User;

public class UserEdit extends PageBase {
    PageBase returnPage;

    public UserEdit(PageBase return_page) {
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

            print("Masukkan ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            User result = orm.Find(id);

            print("Username          : ");
            result.username = scanner.nextLine();
            print("Password          : ");
            result.password = scanner.nextLine();
            print("ID Pegawai        : ");
            result.id_pegawai = scanner.nextInt();
            scanner.nextLine();

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
