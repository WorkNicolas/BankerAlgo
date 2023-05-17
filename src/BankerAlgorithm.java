/**
 * Menu view for BankerAlgo
 *
 * @author 29AjayKumar WorkNicolas
 * @version 2023-05-17
 */

import java.util.Arrays;

/**
 * Procedure:
 * 1. Initialize Values
 * 2. calculateNeed()
 * 3. isSafe()
 */
public class BankerAlgorithm {
    private int process;
    private int resource;
    private int[][] needs;
    private int[][] max;
    private int[][] allocation;
    private int[] available;
    private int[] safeSequence;
    private Model model;
    public BankerAlgorithm(Model model) {
        this.model = model;
        this.process = model.getProcess();
        this.resource = model.getResource();
        this.needs = model.getNeeds();
        this.max = model.getMax();
        this.allocation = model.getAllocation();
        this.available = model.getAvailable();
        this.safeSequence = model.getSafeSequence();
    }
    private void isSafe() {
        int count = 0;
        // visit array to find allocated process
        boolean[] visited = new boolean[process];
        for (int i = 0; i < process; i++) {
            visited[i] = false;
        }
        //work array to store the copy of available resources
        int[] work = new int[resource];
        System.arraycopy(available, 0, work, 0, resource);
        while (count < process) {
            boolean flag = false;
            for (int i = 0; i < process; i++) {
                if (!visited[i]) {
                    int j;
                    for (j = 0; j < resource; j++) {
                        if (needs[i][j] > work[j])
                            break;
                    }
                    if (j == resource) {
                        safeSequence[count++] = i;
                        visited[i] = true;
                        flag = true;

                        for (j = 0; j < resource; j++) {
                            work[j] = work[j] + allocation[i][j];
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        if (count < process) {
            System.out.println("Error: Unsafe System " + count + " < " + process);
        } else {
            // System.out.println("The given System is Safe");
            System.out.println("Safe Sequence:");
            for (int i = 0; i < process; i++) {
                System.out.print("P" + safeSequence[i]);
                if (i != process - 1)
                    System.out.print(" -> ");
            }
        }
    }
    private void calculateNeed() {
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < resource; j++) {
                needs[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }
    private void displayValues() {
        System.out.println("Finding Safe Sequence using Initialized Values");
        System.out.println("Process: " + model.getProcess());
        System.out.println("Resource: " + model.getResource());
        System.out.println("Allocation Matrix:\n" + Arrays.deepToString(model.getAllocation()));
        System.out.println("Max Matrix:\n" + Arrays.deepToString(model.getMax()));
        System.out.println("Available Resource: " + Arrays.toString(model.getAvailable()));

    }
    public void procedure() {
        displayValues();
        calculateNeed();
        isSafe();
        System.out.println();
    }

}
