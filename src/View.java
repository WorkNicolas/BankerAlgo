import java.util.Scanner;
import java.util.Arrays;
public class View {
    Model model;
    public View(Model model) {
        displayMenu();
    }
    public void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("[1] Initialize Values");
        System.out.println("[2] Preset Values");
        System.out.println("[3] Banker's Algorithm");
        System.out.println("[4] Exit");
        System.out.print("Input: ");
    }
    public void initVal(Scanner sc) {
        System.out.println("Initialize Values");

    }
    public int inputInteger(Scanner sc) {
        int integer = -1;
        while (true) {
            try {
                integer = Integer.valueOf(sc.next());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input: " + ex);
            }
        }
        return integer;
    }
    public void presetVal() {
        System.out.println("Preset Values");
        displayVal();
    }
    private void displayVal() {
        System.out.println("Process: " + model.getProcess());
        System.out.println("Resource: " + model.getResource());
        System.out.println("Allocation Matrix:\n" + Arrays.toString(model.getAllocation()));
        System.out.println("Max Matrix:\n4" + Arrays.toString(model.getMax()));
        System.out.println("Available Resource: " + Arrays.toString(model.getAvailable()));
    }
}
