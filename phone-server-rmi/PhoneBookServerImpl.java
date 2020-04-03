import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * 
 * Classe responsável por prover uma implementação para cada um dos
 * métodos remotos presentes na interface PhoneBookServer.
 * Extende de UnicastRemoteObject
 * Implementa a interface PhoneBookServer.
 * 
 * @author João Paulo Back
 *
 */

class PhoneBookServerImpl extends UnicastRemoteObject implements PhoneBookServer{

  public PhoneBookServerImpl() throws RemoteException{
    super();
  }
  
  public ArrayList<PhoneBookEntry> getPhoneBook(){
    try{
      ArrayList<PhoneBookEntry> phoneBookEntryList = new ArrayList<PhoneBookEntry>();
      Scanner scanner = new Scanner(new File("calendar.txt"));
      while(scanner.hasNext()){
        String line = scanner.nextLine();
        String data[] = line.split(";");
        PhoneBookEntry phoneBookEntry = new PhoneBookEntry();
        phoneBookEntry.setFirstName(data[0]);
        phoneBookEntry.setLastName(data[1]);
        phoneBookEntry.setPhoneNumber(data[2]);
        phoneBookEntryList.add(phoneBookEntry);
      }
      return phoneBookEntryList;
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void addEntry(PhoneBookEntry entry){
    try{
      PrintWriter printWriter = new PrintWriter(new FileWriter("calendar.txt", true));
      printWriter.write(entry.getFirstName()+";"+entry.getLastName()+";"+entry.getPhoneNumber()+"\n");
      printWriter.flush();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

}