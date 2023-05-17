import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Model model = new Model();
        View view = new View(model);
        Controller ctrl = new Controller(model, view, sc);
        BankerAlgorithm ba;
        boolean viewed = false;
        boolean initialized = false;
        while (true) {
            if (viewed) {
                ctrl.getView().displayMenu();
            }
            viewed = true;
            int choice;
            try {
                choice = sc.nextInt();
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: " + ex);
                continue;
            }

            switch (choice) {
                case 1 -> {
                    ctrl.initValue();
                    initialized = true;
                }
                case 2 -> {
                    ctrl.setPreset();
                    initialized = true;
                }
                case 3 -> {
                    if (initialized) {
                        ba = new BankerAlgorithm(ctrl.getModel());
                        ba.procedure();
                    } else {
                        System.out.println("Error: Uninitialized values");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting the program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid input: Unavailable option");
            }
        }
    }
}