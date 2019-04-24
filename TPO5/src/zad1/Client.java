package zad1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String... args) throws Exception {
		String host = args[0];
		Registry registry = LocateRegistry.getRegistry(host);
		IPhoneDirectory pd = (IPhoneDirectory) registry.lookup("IPhoneDirectory");
		
		String name = "Maria";
		String num = "12344567";
		boolean addPhoneNumberBoolean = pd.addPhoneNumber(name, num);
		if(addPhoneNumberBoolean) {
			System.out.println("Dodano pomyślnie numer: " + num + " dla osoby: " + name);
		}
		else {
			System.out.println("Nie dodano numer: " + num + " dla osoby: " + name);
		}
		
		String getPhone = pd.getPhoneNumber(name);
		System.out.println("Numer telefonu: " + getPhone + " jest dla osoby " + name);
		
		String newNum = "7654321";
		boolean replacePhoneNumberBoolean = pd.replacePhoneNumber(name, newNum);
		if(replacePhoneNumberBoolean) {
			System.out.println("Zastąpiono numer telefonu na nowy: " + pd.getPhoneNumber(name));
		}
		else {
			System.out.println("Nie zastąpiono numer telefonu na nowy: " + pd.getPhoneNumber(name));
		}
	}
}
