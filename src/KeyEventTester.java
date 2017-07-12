
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTester extends JFrame {

    private int x = 100;
    private int y = 100;
    private char keyChar = 'A';
    private JPanel keyPanel;

    public void initialize() {

        keyPanel = new KeyboardPanel();
        keyPanel.setFocusable(true); // receives keyboard data

        keyPanel.addKeyListener(new KeyObserver());
        Container contentPane = getContentPane();
        contentPane.add(keyPanel, "Center");
        
        JButton b = new JButton("Press me to confuse focusable!");
        contentPane.add(b, "South");
        // The button will receive all key events once you click on it
        // Uncomment the following line to avoid it
        //b.setFocusable(false);
    }

    private class KeyObserver implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                default:
                    keyChar = e.getKeyChar();
            }

            keyPanel.repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

    private class KeyboardPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(1.0F, 0.1F, 0.1F));
            g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
            g.drawString(String.valueOf(keyChar), x, y);
        }
    }
}
