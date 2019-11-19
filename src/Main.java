import com.company.dzennik.logowanie.Login;
import com.company.dzennik.logowanie.Singup;
import com.company.dzennik.logowanie.uczniowie.oceny.User;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<User> list1 = new ArrayList<>();
        System.out.println("Witaj w twoim e-dzienniku" + '\n');
//        list1.add(new User("a","b",1,"1a","123"));
//        list1.add(new User("asd","d",2,"3c","123asd"));
        System.out.println("Zaloguj sie lub załóż konto."+" Wpisz:");
        System.out.println("Login" + '\n' + "Singup" + '\n' + "Co chcesz zrobic: ");


        while (true) {
            String order = sc.nextLine();
            switch (order) {
                case "Singup":
                    System.out.println("podaj imie: ");
                    String name = sc.nextLine();

                    System.out.println("podaj nazwisko: ");
                    String surname = sc.nextLine();

                    System.out.println("podaj swoją klase: ");
                    String clas = sc.nextLine();

                    System.out.println("Podaj haslo: ");
                    String passowrd = sc.nextLine();

                    Singup uczen1 = new Singup(list1);
                    User user = uczen1.singUp(name, surname, clas, passowrd);
                    list1.add(user);
                    System.out.println(list1);
                    System.out.println("Wpisz co chcesz zrobic: ");
                    break;
                case "Login":
                    System.out.println("podaj imie: ");
                    String nameLog = sc.nextLine();

                    System.out.println("podaj nazwisko: ");
                    String surnameLog = sc.nextLine();

                    System.out.println("podaj swoją klase: ");
                    String clasLog = sc.nextLine();

                    System.out.println("Podaj haslo: ");
                    String passowrdLog = sc.nextLine();


                    Login uczen = new Login();
                    User user1 = uczen.login(nameLog, surnameLog, passowrdLog);
                    System.out.println(user1.getName() + " " + user1.getSurname() + " " + user1.getClas());



                    System.out.println("Wpisz co chcesz zrobic: ");

                    break;
                case "Quit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Błędne polecenie");
                    System.out.println("Wpisz co chcesz zrobic: ");
                    break;
            }
            save(list1);
        }
    }

    public static void save(List<User> list) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(new FileOutputStream("text.txt", true));
        for (User user : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(user.getName());
            stringBuilder.append(",");
            stringBuilder.append(user.getSurname());
            stringBuilder.append(",");
            stringBuilder.append(user.getId());
            stringBuilder.append(",");
            stringBuilder.append(user.getClas());
            stringBuilder.append(",");
            stringBuilder.append(user.getPassword());
            zapis.println(stringBuilder.toString());
            zapis.flush();
        }
        zapis.close();
    }
}
