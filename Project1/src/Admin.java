import java.util.Scanner;

public class Admin {
    Admin_Info info = new Admin_Info();
    Candidate candidate = new Candidate();
    String winner = "No Winner Selected";

    Scanner scanner = new Scanner(System.in);
    void login (){
        info.setUsername("admin");
        info.setPassword("admin pass");
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        if(username.equals(info.getUsername())){
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if(password.equals(info.getPassword())){
                System.out.println("Welcome");
                while (true){
                    System.out.println("-------------------------");
                    System.out.println("1.Set Candidate");
                    System.out.println("2.View Candidate");
                    System.out.println("3.Remove Candidate");
                    System.out.println("4.View All Vote");
                    System.out.println("5.Declare Winner");
                    System.out.println("6.Logout");
                    System.out.println("----------------------------");
                    System.out.print("Enter Your Choice: ");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1: candidate.setCandidate();
                            System.out.print("Press Any Key And Enter: ");
                            scanner.next();
                                break;
                        case 2: candidate.view();
                            System.out.print("Press Any Key And Enter: ");
                            scanner.next();
                               break;
                        case 3: candidate.remove();
                            System.out.print("Press Any Key And Enter: ");
                            scanner.next();
                               break;
                        case 4: candidate.viewVote();
                            System.out.print("Press Any Key And Enter: ");
                            scanner.next();
                               break;
                        case 5: setWinner();
                            System.out.print("Press Any Key And Enter: ");
                            scanner.next();
                               break;
                        case 6: return;
                    }
                }
            }
        }
    }
    void setWinner(){
        if(candidate.serial.isEmpty()){
            System.out.println("No Candidate Is Selected");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter The Serial of The Winner: ");
        String serial1 = scanner.nextLine();
        if(candidate.serial.contains(serial1)){
            int index=candidate.serial.indexOf(serial1);
            System.out.println("The Selected Winner Is: "+candidate.name.get(index));
            winner=candidate.name.get(index);
        }
    }
    void printWinner(){
        System.out.println(winner);
    }
}
