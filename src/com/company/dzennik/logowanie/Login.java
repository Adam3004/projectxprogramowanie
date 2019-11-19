package com.company.dzennik.logowanie;

import com.company.dzennik.logowanie.uczniowie.oceny.User;
import sun.applet.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Login {


    public User login(String name, String surname, String clas, String passowrd) throws FileNotFoundException {
        User uczen = new User(name, surname, clas, passowrd);
        File file = new File("text.txt");
        Scanner in = new Scanner(file);
        boolean znaleziono = false;
        while (in.hasNext()) {
            String zdanie = in.nextLine();
            String[] tablica = new String[5];
            tablica = zdanie.split(",");
//        for (int a = 0; a < 5; a++) {
//            System.out.println(tablica[a]);
//        }
            String nametab = tablica[0];
            String surnametab = tablica[1];
            String idtabs = tablica[2];
            int idtab = Integer.parseInt(idtabs);
            String clastab = tablica[3];
            String passwordtab = tablica[4];
            User user = new User(nametab, surnametab, clastab, passwordtab);


            if (uczen.getPassword().equals(user.getPassword()) && uczen.getName().equals(user.getName()) && uczen.getSurname().equals(user.getSurname())) {
                System.out.println("zalogowano");
                znaleziono = true;
                break;
//            System.out.println(uczen);
//            System.out.println(user);
            }
            continue;


        }
        if (znaleziono == false) {
            System.out.println("nieznaleziono użytkownika");
        }

        return uczen;
    }


}

