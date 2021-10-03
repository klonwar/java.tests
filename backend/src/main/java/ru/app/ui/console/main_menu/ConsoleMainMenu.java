package ru.app.ui.console.main_menu;

import ru.app.ui.MainMenuAction;
import ru.app.ui.MainMenuUI;
import ru.app.ui.console.ConsoleSlice;

import java.util.ArrayList;

public class ConsoleMainMenu extends ConsoleSlice implements MainMenuUI {
    @Override
    public MainMenuAction askMainMenuAction() {
        System.out.println("-@ Выберите действие");
        return this.askElementInList(new ArrayList<>() {{
            add(MainMenuAction.CHOOSE_TEST);
            add(MainMenuAction.SEE_RESULTS);
        }}, MainMenuAction::getLabel);
    }
}
