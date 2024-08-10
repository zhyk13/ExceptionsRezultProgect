package view.comands;

import model.BirtDateExeption;
import model.GenderExeption;
import model.NamberDataExeption;
import model.PhoneNumberExeption;
import view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить запись в телефонную книгу";
    }

    public void execute() throws NamberDataExeption, GenderExeption, BirtDateExeption, PhoneNumberExeption {
        consoleUI.addHuman();
    }
}
