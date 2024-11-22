package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String surname;
    private String phone;
    private String code;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.code = generateCode(name, surname);
    }

    private String generateCode(String name, String surname) {
        String[] surnameParts = surname.split("\\s+");
        String firstNameInitial = name.substring(0, 1).toLowerCase();

        if (surnameParts.length == 1) {
            String normalizedSurname = Normalizer.normalize(surnameParts[0], Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "")
                    .toLowerCase();
            return firstNameInitial + normalizedSurname;
        }

        String firstSurnameInitial = surnameParts[0].substring(0, 1).toLowerCase();
        String remainingSurname = String.join("", surnameParts).substring(surnameParts[0].length());

        String normalizedRemaining = Normalizer.normalize(remainingSurname, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();

        return firstNameInitial + firstSurnameInitial + normalizedRemaining;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    public void callMyNumber() {
        System.out.println("Llamando al propio número de " + name + " " + surname + ": " + phone);
    }

    public void callOtherNumber(String number) {
        System.out.println(name + " " + surname + " está llamando al número: " + number);
    }

    public void showContactDetails() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surname);
        System.out.println("Teléfono: " + phone);
        System.out.println("Código: " + code);
    }
}
