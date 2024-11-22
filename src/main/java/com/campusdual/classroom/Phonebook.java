package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
        System.out.println("Contacto añadido: " + contact.getName() + " " + contact.getSurnames());
    }

    public void deleteContact(String code) {
        if (contacts.containsKey(code)) {
            contacts.remove(code);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró el contacto con el código: " + code);
        }
    }

    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contact contact : contacts.values()) {
                contact.showContactDetails();
                System.out.println("----------------------------");
            }
        }
    }

    public Map<String, Contact> getData() {
        return contacts;
    }
}

