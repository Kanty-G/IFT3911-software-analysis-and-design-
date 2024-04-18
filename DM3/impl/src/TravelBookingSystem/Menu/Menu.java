package TravelBookingSystem.Menu;

import java.util.ArrayList;

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
        System.out.println(menuName);
        System.out.println();

        for (int idx = 0; idx < menuItems.size(); idx++)
        {
            MenuItem menuItem = menuItems.get(idx);
            System.out.println("  " + idx + ". " + menuItem.getName());
        }
    }
}
