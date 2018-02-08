package name.saifmahmud.cse470;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main
{
    public static final int SERVER_PORT = 5578;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int n = scan.nextInt();

        try
        {
            Registry registry = LocateRegistry.getRegistry(null, SERVER_PORT);

            Sum w = (Sum) registry.lookup("Worker");
            System.out.println("The sum is: " + w.sum(n));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
