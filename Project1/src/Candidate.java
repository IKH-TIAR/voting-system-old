import java.util.ArrayList;
import java.util.Scanner;

public class Candidate{
    public static ArrayList<String> serial = new ArrayList<>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<String> name= new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    void setCandidate(){
        int i=1;
        int size;
        System.out.print("How Many Candidate To Input: ");
        size = scanner.nextInt();
        scanner.nextLine();
        while (size!=0) {
            System.out.print("Enter Serial for Candidate "+i+" : ");
            String serial1 = scanner.nextLine();
            System.out.print("Enter Name For Candidate "+i+" : ");
            String name1 = scanner.nextLine();
            serial.add(serial1);
            name.add(name1);
            list.add(0);
            i++;
            size--;
        }
    }
   public static void view(){
        if(serial.isEmpty()){
            System.out.println("No Candidate Is Selected");
            return;
        }
        for (int i=0; i<serial.size(); i++){
            System.out.print("Candidate Serial: "+serial.get(i));
            System.out.println("  Candidate Name: "+name.get(i));
        }
    }
    void count(String serial1){
        int index=serial.indexOf(serial1);
        System.out.println("You Want To Vote "+name.get(index));
        System.out.print("If YES Press 1: ");
        String choice =scanner.nextLine();
        if(!choice.equals("1")){
            return;
        }
        int value = list.get(index);
        value+=1;
        list.set(index,value);
    }
    public static void viewVote(){
        if(list.isEmpty()){
            System.out.println("No Candidate Is Selected");
            return;
        }
        for (int i=0; i<list.size(); i++){
            System.out.print("Serial: "+serial.get(i)+" Name: "+name.get(i)+" Total Vote: ");
            System.out.println(list.get(i));
        }
    }
    void remove(){
        if(serial.isEmpty()){
            System.out.println("No Candidate Is Selected");
            return;
        }
        System.out.print("Enter The Serial No Of The Candidate: ");
        String serial1 = scanner.nextLine();
        if(serial.contains(serial1)){
            int index=serial.indexOf(serial1);
            serial.remove(serial1);
            list.remove(index);
            System.out.println("Removed Candidate "+name.get(index));
            name.remove(index);
        }
    }
}
