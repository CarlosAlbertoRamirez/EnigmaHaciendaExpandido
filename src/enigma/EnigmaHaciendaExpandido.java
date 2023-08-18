package enigma;

import javax.swing.JOptionPane;

public class EnigmaHaciendaExpandido {
    
    private GUIEnigmaHacienda gui;
    private String responsable = "hijastro";  // Puedes cambiar este valor para alterar el final del juego.
    
    public EnigmaHaciendaExpandido(GUIEnigmaHacienda gui) {
        this.gui = gui;
        gui.agregarTexto("Bienvenido al Enigma de la Hacienda. Te encuentras en el patio central de la hacienda. ¿Dónde quieres investigar primero?");
    }
    
    public void procesarDecision(String decision) {
        switch (decision) {
            case "sala de juntas":
                gui.agregarTexto("Has encontrado un anillo con el sello del municipio.");
                break;
            case "establo":
                gui.agregarTexto("Has encontrado una pluma que parece pertenecer a un diario.");
                break;
            case "oficina":
                gui.agregarTexto("Has encontrado un sobre vacío con el sello de la policía.");
                break;
            case "bodega":
                gui.agregarTexto("Has encontrado unas huellas que parecen ser recientes.");
                break;
            case "capilla":
                gui.agregarTexto("Ves una vela recién apagada junto a una vieja fotografía.");
                break;
            case "jardín":
                gui.agregarTexto("Encuentras una carta parcialmente quemada que habla de chantajes.");
                break;
            case "cava":
                gui.agregarTexto("Ves un vaso de tequila a medio tomar con huellas dactilares.");
                break;
            case "habitación principal":
                gui.agregarTexto("Descubres un retrato del fundador del pueblo con una nota detrás.");
                break;
            case "resolver":
                gui.agregarTexto("¿Quién crees que es el responsable de la desaparición del documento?");
                String sospechoso = JOptionPane.showInputDialog("Escribe el nombre del sospechoso (presidente/jefe/esposa/hijastro):");
                if (sospechoso.equals(responsable)) {
                    gui.agregarTexto("¡Correcto! El " + responsable + " fue quien se llevó el documento.");
                    System.exit(0);  // Finalizamos el juego
                } else {
                    gui.agregarTexto("Incorrecto. Intenta recolectar más pistas.");
                }
                break;
            default:
                gui.agregarTexto("No reconocí esa opción. Por favor, elige entre los lugares mencionados o 'resolver'.");
                break;
        }
    }
}
