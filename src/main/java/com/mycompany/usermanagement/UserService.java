/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author informatics
 */
public class UserService {

    private static ArrayList<User> userList = new ArrayList<>();
    private static int lastId = 1;

    static {
        User admin = new User(1, "admin", "Administractor", "pass@1234", 'M', 'A');
        User user1 = new User(2, "user1", "user 1", "pass@1234", 'F', 'U');
        User user2 = new User(3, "user2", "user 2", "pass@1234", 'M', 'U');
        addUser(admin);
        addUser(user1);
        addUser(user2);
    }

    public static User addUser(User newUser) {
        newUser.setId(lastId++);
        userList.add(newUser);
        return newUser;

    }

    public static ArrayList<User> getUser() {
        return userList;
    }

    public static User getUser(int index) {
        return userList.get(index);
    }

    public static User getUserByID(int id) {
        for (User u : userList) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static int getSize() {
        return userList.size();
    }

    public static User updateUser(int index, User user) {
        userList.set(index, user);
        return user;
    }

    public static User deleteUser(int index) {
        return userList.remove(index);
    }

    public static void printList() {
        ArrayList<User> list = UserService.getUser();
        for (User u : list) {
            System.out.println(u);
        }
    }

    public static void writeFile() {
        FileOutputStream fos = null;
        File file = null;
        ObjectOutputStream oos = null;
        try {
            file = new File("user.dat");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }

    public static void readFile() {
        FileInputStream fis = null;
        File file = null;
        ObjectInputStream ois = null;
        try {
            file = new File("user.dat");
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            userList = (ArrayList<User>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.getLogger(UserService.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
