package model.servise;

import model.RecordingInPhoneBook;

import java.io.*;

public class FileHandler implements Rewritable{

    @Override
    public boolean saveToFile(RecordingInPhoneBook record, String filename) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt", true))) {
            writer.write(record.getFamily() + " " + record.getName() + " " + record.getPatronymic() + " "
                    + record.getBirthDate() + " " + record.getPhoneNumber() + " " + record.getGender());
            writer.newLine();
            System.out.println("Данные успешно записаны в файл: " + filename);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
            return false;
        }
    }
}
