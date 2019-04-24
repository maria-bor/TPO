package zad1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String... args) throws Exception {
		PhoneDirectory pd = new PhoneDirectory("telKsiążka");
		IPhoneDirectory ipd = (IPhoneDirectory) UnicastRemoteObject.exportObject(pd, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("IPhoneDirectory", ipd); //This object will be captured from client context.
	}
}
