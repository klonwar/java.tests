package ru.app.ui.console;

import java.util.List;
import java.util.Scanner;

public class ConsoleSlice {
    protected <T> T askElementInList(List<T> list, ItemToStringFunction<T> itemToString) {
        for (int i = 0; i < list.size(); i++) {
            var item = list.get(i);
            System.out.println((i + 1) + " - " + itemToString.itemToString(item));
        }

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt() - 1;

        if (i >= 0 && i < list.size()) {
            return list.get(i);
        } else {
            System.out.println("-! Вы ввели неверный номер, повторите попытку");
            return askElementInList(list, itemToString);
        }
    }
}
