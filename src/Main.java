import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Model model = new Model();
        View view = new View(model, sc);
        Controller ctrl = new Controller(model, view);

    }
}