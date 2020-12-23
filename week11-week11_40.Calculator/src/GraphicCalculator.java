
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calc;
    
    public GraphicCalculator(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField output = new JTextField("0");
        output.setEnabled(false);
        JTextField input = new JTextField("0");
        
        
        container.add(output);
        container.add(input);
        container.add(createMenu(input, output));
        

    }
    
    private JPanel createMenu(JTextField input, JTextField output) {
        JPanel panel = new JPanel(new GridLayout(1,3));
        
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton zeroOut = new JButton("Z");
        
        AddListener addListener = new AddListener(calc, input, output, zeroOut);
        add.addActionListener(addListener);
        
        SubtractListener subtractListener = new SubtractListener(calc, input, output, zeroOut);
        subtract.addActionListener(subtractListener);
        
        ZeroOutListener zeroOutListener = new ZeroOutListener(calc, input, output, zeroOut);
        zeroOut.addActionListener(zeroOutListener);
        if (calc.getOutput() == 0) {
            zeroOut.setEnabled(false);
        }
             
        
        panel.add(add);
        panel.add(subtract);
        panel.add(zeroOut);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
