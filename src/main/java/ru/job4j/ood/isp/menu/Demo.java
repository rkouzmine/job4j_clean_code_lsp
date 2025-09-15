package ru.job4j.ood.isp.menu;

public class Demo {
    public static void main(String[] args) {
        final ActionDelegate STUB_ACTION = System.out::println;
        Printer printer = new Printer();
        Menu menu = new SimpleMenu();

        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);

        printer.print(menu);
    }
}
