package presenter;

import model.*;
import model.servise.Service;

public class Presenter {
    private Service service;
    public Presenter(){
        this.service = new Service();
    }

    public RecordingInPhoneBook checkingdata(String string) throws NamberDataExeption, GenderExeption,
            BirtDateExeption, PhoneNumberExeption {
        return service.checkingdata(string);
    }

    public boolean saveToFile(String fileName) {
        return service.saveToFile(fileName);
    }

}
