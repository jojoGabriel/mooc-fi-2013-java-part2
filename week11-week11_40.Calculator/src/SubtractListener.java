
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class SubtractListener implements ActionListener {

    private Calculator calc;
    private JTextField input;
    private JTextField output;
    private JButton zeroOut;

    public SubtractListener(Calculator calc, JTextField input, JTextField output, JButton zeroOut) {
        this.calc = calc;
        this.input = input;
        this.output = output;
        this.zeroOut = zeroOut;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i = 0;
        try {
            i = Integer.parseInt(input.getText());
        } catch (NumberFormatException e) {
            input.setText("");
            return;
        }
        
        calc.subtract(i);
        int o = calc.getOutput();
        
        output.setText(o + "");
        input.setText("");
        
        if (o == 0) {
            zeroOut.setEnabled(false);
        }
    }

}
