package model;

public class GenderExeption extends Exception{
    public GenderExeption(){
        super("Пол введен не корректно! Введите m или f.");
    }
}
