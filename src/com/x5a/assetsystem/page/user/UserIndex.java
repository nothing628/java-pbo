package com.x5a.assetsystem.page.user;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;
import com.x5a.assetsystem.database.User;
import java.util.ArrayList;

public class UserIndex extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new UserNew(this);
            case "2":
                return new UserEdit(this);
            case "3":
                return new UserDelete(this);
            case "4":
                return new MainPage();
            default:
                return this;
        }
    }

    @Override
    public void display() {
        User data = new User();
        ArrayList<User> list_data = data.Select();

        printLine();

        for (User item : list_data) {
            print("| " + item.id + " ");
            print("| " + item.username + " ");
            println("| *** |");
        }

        printLine();
        println("1. User Baru | 2. Edit User | 3. Hapus User | 4. Kembali");
        print("Choose number : ");

        result = scanner.nextLine();
    }
}
