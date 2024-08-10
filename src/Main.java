import model.BirtDateExeption;
import model.GenderExeption;
import model.NamberDataExeption;
import model.PhoneNumberExeption;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) throws NamberDataExeption, GenderExeption,
            BirtDateExeption, PhoneNumberExeption {
        View view = new ConsoleUI();
        view.start();
    }
}