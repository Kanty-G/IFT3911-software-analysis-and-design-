package TravelBookingSystem.Console;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

public class ConsoleUtils
{
    public static String RequestNextLine(String prompt)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void WaitForInput()
    {
        System.out.println("Press Enter to continue...");

        try
        {
            System.in.read(); // Wait for any input
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public static void printAllElements(Enumeration<?> elements)
    {
        System.out.println("---------------");

        while(elements.hasMoreElements())
        {
            System.out.println(" -  " + elements.nextElement());
        }

        System.out.println("---------------");
    }
}
