package model;

import java.io.Serializable;

public class RecordingInPhoneBook implements Serializable {
        private String family;
        private String name;
        private String patronymic;
        private String birthDate;
        private Long phoneNumber;
        private char gender;

        public String getFamily() {
            return this.family;
        }

        public void setFamily(String family) {
            this.family = family;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String nane) {
            this.name = nane;
        }

        public String getPatronymic() {
            return this.patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getBirthDate() {
            return this.birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public Long getPhoneNumber() {
            return this.phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public char getGender() {
            return this.gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

    }
