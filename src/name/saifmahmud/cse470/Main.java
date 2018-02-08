package name.saifmahmud.cse470;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int n = scan.nextInt();

        try
        {
            Registry registry = LocateRegistry.getRegistry(null, 5578);

            Sum w = (Sum) registry.lookup("Worker");
            System.out.println("The sum is: " + w.sum(n));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
