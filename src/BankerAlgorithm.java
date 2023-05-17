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

}
