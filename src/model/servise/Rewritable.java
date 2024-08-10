package model.servise;

import model.RecordingInPhoneBook;

import java.io.Serializable;

public interface Rewritable {
    boolean saveToFile(RecordingInPhoneBook record, String filename);
}
