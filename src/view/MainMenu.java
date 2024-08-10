package view;

import model.BirtDateExeption;
import model.GenderExeption;
import model.NamberDataExeption;
import model.PhoneNumberExeption;
import view.comands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add((new AddHuman(consoleUI)));
        commandList.add(new Finish(consoleUI));
    }

    public int getSize(){
        return commandList.size();
    }

    public void execute(int choice) throws NamberDataExeption, GenderExeption, BirtDateExeption, PhoneNumberExeption {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append((commandList.get(i).getDescription()));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
