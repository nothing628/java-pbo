package com.x5a.assetsystem.page.asset;

import com.x5a.assetsystem.page.MainPage;
import com.x5a.assetsystem.page.PageBase;

public class AssetIndex extends PageBase {
    @Override
    public PageBase getResult() {
        return new MainPage();
    }

    @Override
    public void display() {
        print("Main page");

        String inp = scanner.nextLine();
    }
}