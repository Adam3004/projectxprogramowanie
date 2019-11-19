package com.company.dzennik.logowanie;

import com.company.dzennik.logowanie.uczniowie.oceny.User;

import java.util.List;

public class Singup {
    List<User> list;


    public Singup(List<User> list) {
        this.list = list;
    }

    public User singUp(String name, String surname, int id, String clas, String passowrd) {
        User uczen1 = new User(name, surname, clas, passowrd);
        for (int i = 0; i < list.size(); i++) {
            String nameForList = list.get(i).getName();
            String surnameForList = list.get(i).getSurname();
            int idForList = list.get(i).getId();
            String clasForList = list.get(i).getClas();
            if (name.equals(nameForList) && surname.equals(surnameForList) && id == idForList && clas.equals(clasForList)) {
                System.out.println("taki urzytkownik juz istnieje");
                break;
            }

        }
        return uczen1;


    }


    @Override
    public String toString() {
        return "User: " + list
                ;
    }


}
