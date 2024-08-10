package view;

import model.*;
import presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private boolean work;
    private Scanner scanner;
    private MainMenu menu;
    private Presenter presenter;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        presenter = new Presenter();
    }

    @Override
    public void start(){
        System.out.println("Добрый день!");
        while (work) {
            printMenu();
            execute();
        }
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                try {
                    menu.execute(numCommand);
                } catch (NamberDataExeption | GenderExeption | BirtDateExeption |
                         PhoneNumberExeption e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    public void finish() {
        System.out.println("До свидания! Заходите еще!");
        work = false;
    }

    public void addHuman(){

        System.out.println("Введите: Фамилию, Имя, Отчество, датурождения, номертелефона, пол.");
        System.out.println("Данные можно вводить в произвольном порядке, обязательно разделяя пробелом! ");
        System.out.println("Форматы данных:\n фамилия, имя, отчество - строки\n" +
                "дата_рождения - строка формата dd.mm.yyyy\n" +
                "номер_телефона - целое беззнаковое число без форматирования\n" +
                "пол - символ латиницей f или m");
        String line = scanner.nextLine();
        try {
            RecordingInPhoneBook record  = presenter.checkingdata(line);
            System.out.println("Проверьте правильность введенных данных:");
            System.out.println("Фамилия: " + record.getFamily());
            System.out.println("Имя: " + record.getName());
            System.out.println("Отчество: " + record.getPatronymic());
            System.out.println("Дата рождения: " + record.getBirthDate());
            System.out.println("Номер телефона: " + record.getPhoneNumber());
            System.out.println("Пол: " + record.getGender());
            System.out.println("Если данные введены правильно нажмите 1, если нет, нажмите 2");
            line = scanner.nextLine();
            while (!line.equals("1") && !line.equals("2")){
                System.out.println("Введено не корректное значение. Введите 1 или 2");
                line = scanner.nextLine();
            }
            if (line.equals("1")){
                saveToFile(record.getFamily());
            }
        } catch (NamberDataExeption | GenderExeption | BirtDateExeption | PhoneNumberExeption e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println("Введено не корректное значение");
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void saveToFile(String fileName) {
        boolean rezult;
        rezult = presenter.saveToFile(fileName);
        if (rezult) {
            System.out.println("Данные записаны в файл " + fileName);
        }
        else {
            System.out.println("Ошибка записи");
        }
    }
}
