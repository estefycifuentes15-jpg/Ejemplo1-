package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaInventario extends JFrame {
    private JTextField txtNombre, txtCategoria, txtPrecio, txtStock;
    private JButton btnRegistrar;
    private JTable tablaInventario;
    private DefaultTableModel modeloTabla;

    public VentanaInventario() {
        setTitle("Control de Inventario - Tienda de Barrio (MVC)");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        panelFormulario.add(new JLabel("  Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("  Categoría:"));
        txtCategoria = new JTextField();
        panelFormulario.add(txtCategoria);

        panelFormulario.add(new JLabel("  Precio ($):"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("  Stock:"));
        txtStock = new JTextField();
        panelFormulario.add(txtStock);

        btnRegistrar = new JButton("Registrar Producto");
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnRegistrar);

        add(panelFormulario, BorderLayout.WEST);

        modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Categoría", "Precio ($)", "Stock"}, 0);
        tablaInventario = new JTable(modeloTabla);
        add(new JScrollPane(tablaInventario), BorderLayout.CENTER);
    }

    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtCategoria() { return txtCategoria; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtStock() { return txtStock; }
    public JButton getBtnRegistrar() { return btnRegistrar; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }
}
