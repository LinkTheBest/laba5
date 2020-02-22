import java.util.Scanner;

public class Main extends Thread{

    public static void main(String[] args) {
        UserDataGetter usr = new UserDataGetter();
        System.out.println(usr.command_string);
    }


}
