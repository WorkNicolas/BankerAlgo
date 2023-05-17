public class Controller {
    private Model model;
    private View view;
    public Controller (Model model, View view) {
        this.model = model;
        this.view = view;
    }
    public void updateView(Model model) {
        view.setModel(model);
    }
    public void setPreset() {
        int process = 5;
        int resource = 3;
        int[][] needs = new int[process][resource];
        int[][] max = new int[][] {
                {3,2,2},
                {9,0,2},
                {2,2,2},
                {4,3,3}
        };
        int[][] allocation = new int[][] {
                {0,1,0},
                {2,0,0},
                {3,0,2},
                {2,1,1},
                {0,0,2},
        };
        int[] available = new int[] {3,3,2};
        int[] safeSequence = new int[process];

        model.setProcess(process);
        model.setResource(resource);
        model.setNeeds(needs);
        model.setMax(max);
        model.setAvailable(available);
        model.setSafeSequence(safeSequence);
        updateView(model);
        view.presetVal();
    }
    public View getView() {
        return view;
    }
}
