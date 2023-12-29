package menu;

public class TestMenu {
    public static void main(String[] args) {
        Menu mainMenu = new Menu(null); // Main menu has no parent
        Menu subMenu = new Menu(mainMenu); // Set main menu as the parent of sub menu

        Action a1 = () -> subMenu.build();
        MenuOption o1 = new MenuOption(mainMenu.getChoice(), "Student", new Executable(a1));
        mainMenu.addOption(o1);

        mainMenu.build();
    }
}