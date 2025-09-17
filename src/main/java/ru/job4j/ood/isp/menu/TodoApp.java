package ru.job4j.ood.isp.menu;

import java.util.Scanner;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {
    private final Menu menu = new SimpleMenu();
    private final Printer printer = new Printer();

    private final static ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    private void addItemRoot(Scanner scanner) {
        String item = scanner.nextLine();
        menu.add(Menu.ROOT, item, DEFAULT_ACTION);
        System.out.println("Элемент добавлен в root");
    }

    private void addChildItem(Scanner scanner) {
        String parentItem = scanner.nextLine();
        String childItem = scanner.nextLine();
        menu.add(parentItem, childItem, DEFAULT_ACTION);
        System.out.println("Элемент добавлен к родительскому элементу");
    }

    private void getDelegateItem(Scanner scanner) {
        String item = scanner.nextLine();
        System.out.println(menu.select(item));
    }

    private void printMenu() {
        System.out.println(printer.print(menu));
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean result = true;
        System.out.println("""
                TodoApp - это консольное приложение которое позволяет:
                    1. Добавлять элемент в корень меню
                    2. Добавлять элемент к родительскому элементу
                    3. Вызывать действие, привязанное к пункту меню
                    4. Выводить меню в консоль
                """);
    }
}
