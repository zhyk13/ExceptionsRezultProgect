package view.comands;

import model.BirtDateExeption;
import model.GenderExeption;
import model.NamberDataExeption;
import model.PhoneNumberExeption;
import view.ConsoleUI;

public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute() throws NamberDataExeption, GenderExeption, BirtDateExeption, PhoneNumberExeption;
}
