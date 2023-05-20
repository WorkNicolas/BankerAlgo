/**
 * Menu view for BankerAlgo
 *
 * @author WorkNicolas
 * @version 2023-05-17
 */

import java.util.Scanner;
import java.util.Arrays;
public class View {
    Model model;
    public View(Model model) {
        this.model = model;
        displayMenu();
    }

    /**
     * Display main menu
     *
     */
    public void displayMenu() {
        System.out.println("Banker's Algorithm");
        System.out.println("[1] Initialize Values");
        System.out.println("[2] Preset Values");
        System.out.println("[3] Find Safe Sequence");
        System.out.println("[4] Exit");
        System.out.print("Input: ");
    }

    /**
     * User input
     *
     * @param sc
     */
    public void initVal(Scanner sc) {
        // var
        int process;
        int resource;
        int[][] needs;
        int[][] max;
        int[][] allocation;
        int[] available;
        int[] safeSequence;
        // menu
        System.out.println("Initialize Values");
        process = inputInteger(sc, "Process");
        resource = inputInteger(sc, "Resource");
        needs = new int[process][resource];
        allocation = setMatrix(process, resource, sc, "Allocation");
        max = setMatrix(process, resource, sc, "Max");
        available = setVector(sc, "Available");
        safeSequence = new int[process];
        // setters
        model.setProcess(process);
        model.setResource(resource);
        model.setNeeds(needs);
        model.setAllocation(allocation);
        model.setMax(max);
        model.setAvailable(available);
        model.setSafeSequence(safeSequence);
        // display
        displayVal();
    }

    /**
     * Reusable user input for integers
     *
     * @param sc
     * @param text name of variable
     * @return
     */
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

    /**
     * Reusable user input for integer arrays
     *
     * @param sc
     * @param text
     * @return
     */
    public int[] setVector(Scanner sc, String text) {
        boolean isValidInput = false;
        int[] array = null;
        while (!isValidInput) {
            sc.reset();
            try {
                System.out.print("[IN IN IN ...] " + text + ": ");
                String input = sc.nextLine();

                // Split the input string into individual elements
                String[] elements = input.split(" ");

                // Create an array with the same size as the number of elements
                array = new int[elements.length];

                // Parse each element and store it in the array
                for (int i = 0; i < elements.length; i++) {
                    array[i] = Integer.parseInt(elements[i]);
                }

                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers separated by space.");
            }
        }

        return array;
    }

    /**
     * Reusable user input for integer multidimensional arrays
     *
     * @param m
     * @param n
     * @param sc
     * @param text
     * @return
     */
    public int[][] setMatrix(int m, int n, Scanner sc, String text) {
        sc.reset();
        int[][] matrix = new int[m][n];
        System.out.println("Set " + text);
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

    /**
     * Display preset values
     *
     */
    public void presetVal() {
        System.out.println("Preset Values");
        displayVal();
    }

    /**
     * Display values
     *
     */
    private void displayVal() {
        System.out.println("Process: " + model.getProcess());
        System.out.println("Resource: " + model.getResource());
        System.out.println("Allocation Matrix:\n" + Arrays.deepToString(model.getAllocation()));
        System.out.println("Max Matrix:\n" + Arrays.deepToString(model.getMax()));
        System.out.println("Available Resource: " + Arrays.toString(model.getAvailable()));
    }

    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
}
