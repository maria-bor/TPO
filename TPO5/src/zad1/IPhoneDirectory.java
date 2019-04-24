package zad1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPhoneDirectory extends Remote{
	// Zwraca numer telefonu dla podanej osoby
	  public String getPhoneNumber(String name) throws RemoteException;

	  // Dodaje nową osobę do książki
	  // Wynik:
	  // - true - dodana
	  // - false - nie (przy próbie dodania osoby zapisanej już w książce)
	  public boolean addPhoneNumber(String name, String num) throws RemoteException;

	  // Zastępuje numer podanej osoby nowym
	  // Wynik:
	  // - true (numer zastąpiony)
	  // - false (nie - próba podania nowegu numeru nieistniejącej osoby)
	  public boolean replacePhoneNumber(String name, String num) throws RemoteException;
}
