import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Registery {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
    try{
      PhoneBookServerImpl phoneBookServerImpl = new PhoneBookServerImpl();
      Registry reg = LocateRegistry.createRegistry(3099);
      reg.bind("phonebook", phoneBookServerImpl);
      System.out.println("Aguardando requisições...");
    } catch (RemoteException | AlreadyBoundException ex) {
      System.out.println(ex);
    }
	}
}