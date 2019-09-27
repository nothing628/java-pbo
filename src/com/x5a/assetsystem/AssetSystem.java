package com.x5a.assetsystem;

import java.util.ArrayList;

import com.x5a.assetsystem.database.User;

public class AssetSystem {

	public static void main(String[] args) {
		User base = new User();
		ArrayList<User> result = base.Select();
		
		for (User user : result) {
			System.out.println(user.username);
		}
	}
}
