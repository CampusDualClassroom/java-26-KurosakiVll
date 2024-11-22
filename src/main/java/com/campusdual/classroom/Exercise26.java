package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú de la Agenda Telefónica:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Eliminar contacto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String surname = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    String phone = scanner.nextLine();
                    Contact newContact = new Contact(name, surname, phone);
                    phonebook.addContact(newContact);
                    break;

                case 2:
                    phonebook.showPhonebook();
                    break;

                case 3:
                    System.out.print("Ingrese el código del contacto a eliminar: ");
                    String code = scanner.nextLine();
                    phonebook.deleteContact(code);
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);

        scanner.close();
    }
}

