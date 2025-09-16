package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PrinterTest {
    private final static ActionDelegate STUB_ACTION = System.out::println;
    private final Printer printer = new Printer();
    private final Menu menu = new SimpleMenu();

    @Test
    public void whenPrinterPrintsMenuThenOutputIsCorrect() {
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        String result = printer.print(menu);
        String expected = """
                1. Сходить в магазин
                ----1.1. Купить продукты
                --------1.1.1. Купить хлеб
                --------1.1.2. Купить молоко
                2. Покормить собаку
                """;
        assertThat(result).isEqualTo(expected);
    }
}