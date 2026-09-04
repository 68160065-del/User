/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermanagement;
import java.util.ArrayList;
/**
 *
 * @author informatics
 */
public class TestUser {
    public static void main(String[] args) {
        User admin = new User(1,"admin","Administractor","pass@1234",'M','A');
        User usr1 = new User(2,"user1","user 1","pass@1234",'F','U');
        User usr2 = new User(3,"user2","user 2","pass@1234",'M','U');
        ArrayList<User> userList = new ArrayList<>(); //generic type
        userList.add(admin);
        userList.add(usr1);
        userList.add(usr2);
        for(int i =0; i<userList.size();i++){
            System.out.println(userList.get(i));//want index
        }
        userList.remove(0);
        userList.set(0, admin);
        for (User u : userList){
            System.out.println(u);
        }
    }
}
