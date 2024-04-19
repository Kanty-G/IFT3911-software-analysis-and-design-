package TravelBookingSystem.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements MenuComponent
{
    private final String menuName;
    private final ArrayList<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String menuName)
    {
        this.menuName = menuName;
    }

    public Menu(String menuName, Menu parent)
    {
        this.menuName = menuName;
        menuComponents.add(new MenuActionItem("Previous Menu", parent::select));
    }

    public String getName()
    {
        return menuName;
    }

    public void select()
    {
        displayMenu();
    }

    public void addMenuComponent(MenuComponent menuComponent)
    {
        menuComponents.add(menuComponent);
    }

    public void removeMenuComponent(MenuComponent menuComponent)
    {
        menuComponents.remove(menuComponent);
    }

    private void displayMenu()
    {
        clearConsole();
        System.out.println(menuName);
        System.out.println();

        for (int idx = 0; idx < menuComponents.size(); idx++)
        {
            MenuComponent menuComponent = menuComponents.get(idx);
            System.out.println("  " + idx + ". " + menuComponent.getName());
        }

        selectNextMenuItem();
    }

    private void clearConsole()
    {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void selectNextMenuItem()
    {
        Scanner scanner = new Scanner(System.in);
        String selection;
        do {
            System.out.println("Please select an option:");
            selection = scanner.nextLine();
        } while (!isValidSelection(selection));

        int index = Integer.parseInt(selection);
        menuComponents.get(index).select();
    }

    private boolean isValidSelection(String selection)
    {
        int index = 0;
        try {
            index = Integer.parseInt(selection);
        }
        catch (Exception exception)
        {
            return false;
        }

        return index >= 0 && index < menuComponents.size();
    }
}
