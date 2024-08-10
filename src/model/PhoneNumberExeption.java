package model;

public class PhoneNumberExeption extends Exception{
    public PhoneNumberExeption(){
        super("Телефон введен не корректно!");
    }
}
