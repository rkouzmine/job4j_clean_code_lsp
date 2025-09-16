package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {
    @Override
    public String print(Menu menu) {
        String str = "----";
        StringBuilder sb = new StringBuilder();
        for (Menu.MenuItemInfo m : menu) {
            int count = m.getNumber().split("\\.").length - 1;
            sb.append(str.repeat(count))
                    .append(m.getNumber()).append(" ")
                    .append(m.getName())
                    .append("\n");
        }
        return sb.toString();
    }
}
