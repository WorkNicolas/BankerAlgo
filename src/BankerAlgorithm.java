public class BankerAlgorithm {
    private int process;
    private int resource;
    private int[][] needs;
    private int[][] max;
    private int[][] allocation;
    private int[] available;
    private int[] safeSequence;
    public BankerAlgorithm(Model model) {
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
        boolean visited[] = new boolean[process];
        for (int i = 0; i < process; i++) {
            visited[i] = false;
        }
        //work array to store the copy of available resources
        int work[] = new int[resource];
        for (int i = 0; i < resource; i++) {
            work[i] = available[i];
        }
        while (count < process) {
            boolean flag = false;
            for (int i = 0; i < process; i++) {
                if (visited[i] == false) {
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
            if (flag == false) {
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

}
