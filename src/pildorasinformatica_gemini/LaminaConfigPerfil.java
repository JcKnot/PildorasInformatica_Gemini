
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jose Castillo
 *
 */
public class LaminaConfigPerfil extends JPanel {
    private JTextArea txtArea;
    private JCheckBox checkAjusteLinea, checkNegrita, checkCursiva;
    private Font font;
            
    public LaminaConfigPerfil(){
        setLayout(new BorderLayout());
        font = new Font("Serif", Font.PLAIN, 24);
        txtArea = new JTextArea (8,20);
        txtArea.setFont(font);
        JScrollPane panelArea = new JScrollPane(txtArea);
        add(panelArea, BorderLayout.CENTER);
        
        JPanel panelControl = new JPanel();
        panelControl.setLayout(new FlowLayout());
        checkAjusteLinea = new JCheckBox("Ajuste de Línea");
        checkAjusteLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !txtArea.getLineWrap();
                txtArea.setLineWrap(saltar);
            }
        });
        checkNegrita = new JCheckBox("Negrita");
        checkNegrita.addActionListener(new actionCheckFont());
        checkCursiva = new JCheckBox("Cursiva");
        checkCursiva.addActionListener(new actionCheckFont());        
        panelControl.add(checkAjusteLinea);
        panelControl.add(checkNegrita);
        panelControl.add(checkCursiva);
        add(panelControl, BorderLayout.SOUTH);
    }
    
    private class actionCheckFont implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int tipo = 0;
            tipo += checkNegrita.isSelected()? Font.BOLD : Font.PLAIN;
            tipo += checkCursiva.isSelected()? Font.ITALIC : Font.PLAIN;
            txtArea.setFont(new Font("Serif", tipo, 24));
        }
        
    }

}
