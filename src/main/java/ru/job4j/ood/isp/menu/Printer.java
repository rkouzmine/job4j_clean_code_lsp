package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        String str = "----";
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (Menu.MenuItemInfo m : menu) {
            int count = m.getNumber().split("\\.").length - 1;
            sb.append(str.repeat(count))
                    .append(m.getNumber()).append(" ")
                    .append(m.getName())
                    .append(ln);
        }
        System.out.println(sb);
    }
}
