package TravelBookingSystem.Menu;

import TravelBookingSystem.Default.Command;

public class MenuActionItem implements MenuItem
{
    private final String actionName;
    private final Action action;

    public MenuActionItem(String actionName, Action action)
    {
        this.actionName = actionName;
        this.action = action;
    }

    public String getName() {
        return actionName;
    }

    public void select() {
        action.execute();
    }
}
