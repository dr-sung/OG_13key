
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        KeyEventTester frame = new KeyEventTester();
        frame.initialize();
        frame.setSize(500, 300);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
