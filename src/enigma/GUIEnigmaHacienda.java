package enigma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEnigmaHacienda {

    private JFrame frame;
    private JTextArea textArea;
    private JComboBox<String> lugaresComboBox;
    private JButton explorarBoton;
    private EnigmaHaciendaExpandido logicaJuego;

    public GUIEnigmaHacienda() {
        
        frame = new JFrame("Enigma de la Hacienda");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        lugaresComboBox = new JComboBox<>(new String[] {"sala de juntas", "establo", "oficina", "bodega", "capilla", "jardín", "cava", "habitación principal", "resolver"});
        
        explorarBoton = new JButton("Explorar");
        explorarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String decision = (String) lugaresComboBox.getSelectedItem();
                logicaJuego.procesarDecision(decision);
            }
        });
        
        JPanel panelInferior = new JPanel();
        panelInferior.add(lugaresComboBox);
        panelInferior.add(explorarBoton);
        
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(panelInferior, BorderLayout.SOUTH);
        
        logicaJuego = new EnigmaHaciendaExpandido(this); // Esta línea ha sido movida aquí, después de la inicialización de todos los componentes.

        frame.setVisible(true);
    }

    public void agregarTexto(String texto) {
        textArea.append(texto + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIEnigmaHacienda();
        });
    }
}

