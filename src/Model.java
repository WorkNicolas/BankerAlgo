public class Model {
    private int process;
    private int resource;
    private int[][] needs;
    private int[][] max;
    private int[][] allocation;
    private int[] available;
    private int[] safeSequence;

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int[][] getNeeds() {
        return needs;
    }

    public void setNeeds(int[][] needs) {
        this.needs = needs;
    }

    public int[][] getMax() {
        return max;
    }

    public void setMax(int[][] max) {
        this.max = max;
    }

    public int[][] getAllocation() {
        return allocation;
    }

    public void setAllocation(int[][] allocation) {
        this.allocation = allocation;
    }

    public int[] getAvailable() {
        return available;
    }

    public void setAvailable(int[] available) {
        this.available = available;
    }

    public int[] getSafeSequence() {
        return safeSequence;
    }

    public void setSafeSequence(int[] safeSequence) {
        this.safeSequence = safeSequence;
    }
}

