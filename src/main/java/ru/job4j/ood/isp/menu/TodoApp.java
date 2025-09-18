package ru.job4j.ood.isp.menu;

import org.jetbrains.annotations.NotNull;
import ru.job4j.ood.isp.menu.Menu.MenuItemInfo;

import java.util.Optional;
import java.util.Scanner;

public class TodoApp {
    private final static  ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");
    private final SimpleMenu menu = new SimpleMenu();
    private final Printer printer = new Printer();

    private void addItemRoot(@NotNull Scanner scanner) {
        System.out.println("Введите имя элемента");
        String item = scanner.nextLine();
        menu.add(Menu.ROOT, item, DEFAULT_ACTION);
        System.out.println("Элемент добавлен в корень меню");
    }

    private void addChildItem(@NotNull Scanner scanner) {
        System.out.println("Введите имя родительского элемента");
        String parentItem = scanner.nextLine();

        Optional<MenuItemInfo> selected = menu.select(parentItem);

        if (selected.isPresent()) {
            System.out.println("Введите имя дочернего элемента");
            String childItem = scanner.nextLine();
            menu.add(parentItem, childItem, DEFAULT_ACTION);
            System.out.printf("Элемент '%s' добавлен к элементу '%s'%n", childItem, parentItem);
        } else {
            System.out.printf("Элемент '%s' не найден%n", parentItem);
        }
    }

    private void getDelegateItem(@NotNull Scanner scanner) {
        System.out.println("Введите имя элемента, чтобы вызвать его действие");
        String item = scanner.nextLine();
        Optional<MenuItemInfo> selected = menu.select(item);
        if (selected.isPresent()) {
            selected.get().getActionDelegate().delegate();
        } else {
            System.out.printf("Элемент '%s' не найден%n", item);
        }
    }

    private void printMenu() {
        System.out.println(printer.print(menu));
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        Scanner scanner = new Scanner(System.in);

        boolean result = true;
        System.out.println("""
                TodoApp - это консольное приложение которое позволяет:
                    1. Добавлять элемент в корень меню
                    2. Добавлять элемент к родительскому элементу
                    3. Вызывать действие, привязанное к пункту меню
                    4. Выводить меню в консоль
                    
                Чтобы закрыть приложение нажмите 0
                """);

        while (result) {
            String str = "Введите число от 0 до 4";
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(str);
                continue;
            }
            switch (choice) {
                case 1 -> app.addItemRoot(scanner);
                case 2 -> app.addChildItem(scanner);
                case 3 -> app.getDelegateItem(scanner);
                case 4 -> app.printMenu();
                case 0 -> {
                    result = false;
                }
                default -> System.out.println(str);
            }
        }
    }
}
