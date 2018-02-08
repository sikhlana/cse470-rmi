package name.saifmahmud.cse470;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sum extends Remote {
    int sum(int n) throws RemoteException;
}
