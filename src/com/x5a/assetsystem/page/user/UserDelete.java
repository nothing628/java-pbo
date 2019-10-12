package com.x5a.assetsystem.page.user;

import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.User;

public class UserDelete extends PageBase {
    PageBase returnPage;

    public UserDelete(PageBase return_page) {
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
