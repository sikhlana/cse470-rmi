package name.saifmahmud.cse470;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Worker implements Sum
{
    public static void main(String[] args)
    {
        Worker w = new Worker();

        try
        {
            Sum stub = (Sum) UnicastRemoteObject.exportObject(w, Main.SERVER_PORT);
            Registry registry = LocateRegistry.createRegistry(Main.SERVER_PORT);
            registry.bind("Worker", stub);

            System.out.println("Worker is ready!");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int sum(int n)
    {
        int sum = 0;
        System.out.println("Got: " + n);

        for (int i = 1; i <= n; i++)
        {
            sum += i;
        }

        return sum;
    }
}