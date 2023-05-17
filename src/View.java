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
        int process;
        int resource;
        int[][] needs;
        int[][] max;
        int[][] allocation;
        int[] available;
        System.out.println("Initialize Values");
        process = inputInteger(sc, "Process");
        resource = inputInteger(sc, "Resource");
        needs = new int[process][resource];

    }
    public int inputInteger(Scanner sc, String text) {
        int integer = -1;
        while (true) {
            System.out.println("[IN] " + text + ":");
            try {
                integer = Integer.valueOf(sc.next());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input: " + ex);
            }
        }
        return integer;
    }
    public int[][] setMatrix(int m, int n, Scanner sc) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.print("[IN IN IN ...] Row " + (i + 1) + ": ");
            String rowInput = sc.nextLine();
            String[] elements = rowInput.split(" ");
            while (elements.length != n) {
                System.out.println("Invalid row input: Enter " + n + " elements.");
                System.out.print("[IN IN IN ...] Row " + (i + 1) + ": ");
                rowInput = sc.nextLine();
                elements = rowInput.split(" ");
            }
            // Parse the elements and store them in the matrix
            for (int j = 0; j < n; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid element: " + ex);
                    j--; // Re-prompt for the same element
                }
            }
        }
        return matrix;
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
