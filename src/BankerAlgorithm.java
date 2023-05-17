/**
 * Menu view for BankerAlgo
 *
 * @author 29AjayKumar WorkNicolas
 * @version 2023-05-17
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    private String out = "";
    private Queue<int[]> aq = new LinkedList<>();
    public BankerAlgorithm(Model model) {
        this.model = model;
        this.process = model.getProcess();
        this.resource = model.getResource();
        this.needs = model.getNeeds();
        this.max = model.getMax();
        this.allocation = model.getAllocation();
        this.available = model.getAvailable();
        this.safeSequence = model.getSafeSequence();
        aq.offer(model.getAvailable());
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
                            int[] instance = aq.peek();
                            if (!Arrays.equals(instance, work)) {
                                aq.offer(Arrays.copyOf(work, resource));
                                // System.out.println(Arrays.toString(work));
                            }
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
                this.out += ("P" + safeSequence[i]);
                if (i != process - 1) {
                    this.out += "→";
                }

            }
        }
    }
    public String getOut() {
        return out;
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
    private void displayFinalOutput() {
        System.out.println("No. of Process: " + process);
        System.out.println("Resources-Instances: " + Arrays.toString(available));
        System.out.println("| Process | Allocation | Max | Available | Need |");
        System.out.print("| ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < resource; j++) {
                char letter = (char) ('A' + j);
                System.out.print(letter + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
        for (int i = 0; i < process; i++) {
            System.out.print("| P" + i);
            System.out.print(" | ");
            for (int j = 0; j < resource; j++) {
                System.out.print(allocation[i][j] + " ");
            }
            System.out.print(" | ");
            for (int j = 0; j < resource; j++) {
                System.out.print(max[i][j] + " ");
            }
            System.out.print(" | ");
            int[] instance = aq.peek();
            for (int j = 0; j < resource; j++) {
                System.out.print(instance[j] + " ");
            }
            while (Arrays.equals(instance, aq.peek())) {
                aq.poll();
            }
            System.out.print(" | ");
            for (int j = 0; j < resource; j++) {
                System.out.print(needs[i][j] + " ");
            }
            System.out.print(" |");
            System.out.println();
        }
    }
    public void procedure() {
        displayValues();
        calculateNeed();
        isSafe();
        displayFinalOutput();
    }

}
