import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User extends Methods{
    Scanner scanner = new Scanner(System.in);
    HashMap<String, String> register_info = new HashMap<>();
    ArrayList<String> not_voted =new ArrayList<>();
    Candidate candidate = new Candidate();
    void userRegistrationMenu(){
        while (true){
            System.out.println("----------------------");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Main Menu");
            System.out.println("-----------------------");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==1){
                register();
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            }else if(choice==2){
                login();
            } else if (choice==3) {
                return;
            }else System.out.println("Invalid Input");
        }
    }
    void register(){
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        if(register_info.containsKey(username)){
            System.out.println("Username Is Already Taken");
            return;
        }
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        register_info.put(username,password);
        System.out.println("Registration Complete");
        System.out.println("Login To Vote");
        not_voted.add(username);
    }
    void login(){
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        if(register_info.containsKey(username)) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if(register_info.get(username).equals(password)){
                userMenu(username);
            }else System.out.println("Wrong PassWord");
        }else System.out.println("Wrong Username");
    }
    void userMenu(String username){
        while (true) {
            System.out.println("-----------------------");
            System.out.println("1.View Candidate");
            System.out.println("2.Vote");
            System.out.println("3.Logout");
            System.out.println("------------------------");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            if(choice==1){
               candidate.view();
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            }else if(choice==2){
                vote(username);
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            } else if (choice==3)return;
            else System.out.println("Invalid Input");
        }
    }
    void vote(String username){
        if(Candidate.serial.isEmpty()){
            System.out.println("Nor Candidate Is Selected");
            return;
        }
        scanner.nextLine();
        if(!not_voted.contains(username)){
            System.out.println("Your Already Voted");
            return;
        }
        System.out.print("Enter the Serial No: ");
        String serial =scanner.nextLine();
        candidate.count(serial);
        System.out.println("Vote Complete");
        not_voted.set(not_voted.indexOf(username),"0");
    }
}
