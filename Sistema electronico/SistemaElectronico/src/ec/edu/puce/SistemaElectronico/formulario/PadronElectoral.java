package ec.edu.puce.SistemaElectronico.formulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class PadronElectoral extends JInternalFrame {
    private DefaultTableModel model;
    private JTable table;

    public PadronElectoral() {
        setTitle("Padrón Electoral");
        setClosable(true); // Permitir cerrar la ventana interna
        setSize(600, 400);
        setLocation(100, 100);

        // Crear la tabla y su modelo
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre", "Curso/Partido"});
        table = new JTable(model);

        // Agregar la tabla a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane al contenido de la ventana
        getContentPane().add(scrollPane);

        // Establecer el diseño del contenido
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
    }

    // Método para actualizar el padrón electoral con la información de estudiantes y candidatos
    public void actualizarPadron(Vector<Vector<Object>> estudiantes, Vector<Vector<Object>> candidatos) {
        // Limpiar el modelo actual
        model.setRowCount(0);

        // Agregar filas correspondientes a estudiantes
        for (Vector<Object> estudiante : estudiantes) {
            model.addRow(estudiante);
        }

        // Agregar filas correspondientes a candidatos
        for (Vector<Object> candidato : candidatos) {
            model.addRow(candidato);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        SwingUtilities.invokeLater(() -> {
            PadronElectoral padronElectoral = new PadronElectoral();
            padronElectoral.setVisible(true);

            // Supongamos que tienes una lista de estudiantes y candidatos
            Vector<Vector<Object>> estudiantes = new Vector<>();
            Vector<Object> estudiante1 = new Vector<>(3);
            estudiante1.add("ID-001");
            estudiante1.add("Estudiante1");
            estudiante1.add("Curso1");
            estudiantes.add(estudiante1);

            // Hacer lo mismo para más estudiantes

            Vector<Vector<Object>> candidatos = new Vector<>();
            Vector<Object> candidato1 = new Vector<>(3);
            candidato1.add("ID-C001");
            candidato1.add("Candidato1");
            candidato1.add("Partido1");
            candidatos.add(candidato1);

            // Hacer lo mismo para más candidatos

            padronElectoral.actualizarPadron(estudiantes, candidatos);
        });
    }
}
