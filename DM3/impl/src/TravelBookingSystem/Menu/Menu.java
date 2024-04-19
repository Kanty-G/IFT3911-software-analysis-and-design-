package TravelBookingSystem.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements MenuItem
{
    private final String menuName;
    private final ArrayList<MenuItem> menuItems = new ArrayList<>();

    public Menu(String menuName)
    {
        this.menuName = menuName;
    }

    public Menu(String menuName, Menu parent)
    {
        this.menuName = menuName;
        menuItems.add(new MenuActionItem("Previous Menu", parent::select));
    }

    public String getName()
    {
        return menuName;
    }

    public void select()
    {
        displayMenu();
    }

    public void AddMenuItem(MenuItem menuItem)
    {
        menuItems.add(menuItem);
    }

    public void RemoveMenuItem(MenuItem menuItem)
    {
        menuItems.remove(menuItem);
    }

    private void displayMenu()
    {
        clearConsole();
        System.out.println(menuName);
        System.out.println();

        for (int idx = 0; idx < menuItems.size(); idx++)
        {
            MenuItem menuItem = menuItems.get(idx);
            System.out.println("  " + idx + ". " + menuItem.getName());
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
        } while (!IsValidSelection(selection));

        int index = Integer.parseInt(selection);
        menuItems.get(index).select();
    }

    private boolean IsValidSelection(String selection)
    {
        int index = 0;
        try {
            index = Integer.parseInt(selection);
        }
        catch (Exception exception)
        {
            return false;
        }

        return index >= 0 && index < menuItems.size();
    }
}
