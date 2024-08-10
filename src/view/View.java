package view;

import model.BirtDateExeption;
import model.GenderExeption;
import model.NamberDataExeption;
import model.PhoneNumberExeption;

public interface View {
    void start() throws NamberDataExeption, GenderExeption, BirtDateExeption, PhoneNumberExeption;
}
