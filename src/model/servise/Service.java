package model.servise;

import model.*;

public class Service {
    private RecordingInPhoneBook record;
    private Rewritable fileHandler = new FileHandler();


    public RecordingInPhoneBook checkingdata (String string) throws NamberDataExeption, GenderExeption,
            BirtDateExeption, PhoneNumberExeption {
        if (string.isEmpty()){
            throw new NamberDataExeption("Данные введены не полностью!");
        }
        String[] parts = string.split("\\s+");
        checkNumData(parts);
        return createRecordingInPhoneBook(parts);

    }

    public void checkNumData(String[] parts) throws NamberDataExeption, GenderExeption,
            BirtDateExeption, PhoneNumberExeption{
        if (parts.length < 6){
            throw new NamberDataExeption("Данные введены не полностью!");
        }
        else {
            if (parts.length > 6) {
                throw new NamberDataExeption("Введены лишние данные!");
            }
        }
        checkGender(parts);
    }

    public void checkGender(String[] parts) throws GenderExeption, BirtDateExeption, PhoneNumberExeption{
        int num = 0;
        for (int i = 0; i < 6; i++) {
            if (parts[i].equals("f") || parts[i].equals("m")){
                num++;
            }
        }
        if (num == 1){
            checkBirtDate(parts);
        }
        else {
            throw new GenderExeption();
        }
    }

    public void checkBirtDate(String[] parts) throws BirtDateExeption, PhoneNumberExeption{
        int num = 0;
        int numDit = 0;
        for (int i = 0; i < 6; i++) {
            if ((parts[i].length() == 10) &&
                    (parts[i].charAt(2) == '.') &&
                    parts[i].charAt(5) == '.'){
                for (int j = 0; j < parts[i].length(); j++) {
                    if (j != 2 && j != 5) {
                        if (Character.isDigit(parts[i].charAt(j))) {
                            numDit++;
                        }
                    }
                }
                if (numDit == 8){
                    num++;
                }
            }
            numDit = 0;
        }
        if (num == 1){
            checkPhoneNumber(parts);
        }
        else {
            throw new BirtDateExeption();
        }
    }

    public void checkPhoneNumber(String[] parts) throws PhoneNumberExeption{
        int num = 0;
        for (int i = 0; i < 6; i++){
            try {
                Long.parseLong(parts[i]);
                num++;
            }
            catch (NumberFormatException e){
                continue;
            }
        }
        if (num != 1){
            throw new PhoneNumberExeption();
        }
    }

    public RecordingInPhoneBook createRecordingInPhoneBook(String[] parts) {
        record = new RecordingInPhoneBook();

        for (String part : parts) {
            if (part.equals("f") || part.equals("m")) {
                record.setGender(part.charAt(0));
            } else if (part.length() == 10 && part.charAt(2) == '.' && part.charAt(5) == '.') {
                record.setBirthDate(part);
            } else {
                try {
                    Long phoneNumber = Long.parseLong(part);
                    record.setPhoneNumber(phoneNumber);
                } catch (NumberFormatException e) {
                    if (record.getFamily() == null) {
                        record.setFamily(part);
                    } else if (record.getName() == null) {
                        record.setName(part);
                    } else if (record.getPatronymic() == null) {
                        record.setPatronymic(part);
                    }
                }
            }
        }
        return record;
    }

    public boolean saveToFile(String fileName) {
        return fileHandler.saveToFile(record, fileName);
    }

}
