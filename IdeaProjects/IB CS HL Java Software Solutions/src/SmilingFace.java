import javax.swing.JFrame;
public class SmilingFace
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Smiling Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SmilingFacePanel panel = new SmilingFacePanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}