import Vista.VentanaInventario;
import Controlador.ControladorInventario;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaInventario vista = new VentanaInventario();
            new ControladorInventario(vista);
            vista.setVisible(true);
        });
    }
}