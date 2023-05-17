import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Model model = new Model();
        View view = new View(model);
        Controller ctrl = new Controller(model, view);
        while (true) {
            while (true) {
                ctrl.getView().displayMenu();

                int choice = 0;
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid choice.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        ctrl.getView().initVal(sc);
                        break;
                    case 2:
                        ctrl.setPreset();
                        break;
                    case 3:
                        // Implement Banker's Algorithm functionality
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }
    }
}