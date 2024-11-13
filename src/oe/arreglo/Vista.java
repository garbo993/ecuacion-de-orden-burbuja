
package oe.arreglo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Vista extends JFrame implements ActionListener {
    
    private JTextField tftamaño;
    private JRadioButton rbmejor,rbpeor,rbmedio;
    private JLabel  lformula, lcontador, lecuacion, lmejor,lpeor,lmedio,ltamaño,lresformula,lrescontador,lresecuacion,lcomplejidad;
    private JPanel p1;
    private JButton bcalcular;
    private ButtonGroup grupobotones;
    private JFrame v;
    private Calculo c = new Calculo();
    private String respuesta,contador;
    
    Vista(){
     CrearComponentes();
     CrearVentana();
    }

    private void CrearComponentes() {
        p1 = new JPanel();
        p1.setLayout(null);
        lcontador = new JLabel("Por Contador: ");
        lformula = new JLabel("Por Formula: ");
        lecuacion = new JLabel("La ecuacion temporal es: ");
        ltamaño = new JLabel("Ingrese el tamaño del arreglo:");
        tftamaño = new JTextField();
        bcalcular = new JButton("Calcular operaciones Elementales");
        rbmejor = new JRadioButton("Mejor caso.",true);
        rbpeor = new JRadioButton("Peor caso.",false);
        rbmedio = new JRadioButton("Caso medio.",false);
        grupobotones = new ButtonGroup();
        rbmejor.setBounds(10, 70, 100, 30);
        rbmedio.setBounds(10, 100, 100, 30);
        rbpeor.setBounds(10, 130, 100, 30); 
        grupobotones.add(rbmejor);
        grupobotones.add(rbpeor);
        grupobotones.add(rbmedio);
        ltamaño.setBounds(20, 30, 200, 30);
        tftamaño.setBounds(200, 30, 50, 30);
        bcalcular.setBounds(20, 180, 250, 30);
        bcalcular.addActionListener(this);
        p1.add(ltamaño);
        p1.add(rbmedio);
        p1.add(rbmejor);
        p1.add(rbpeor);
        p1.add(bcalcular);
        p1.add(tftamaño);
    }

    private void CrearVentana() {
        v = new JFrame();
        v.setSize(300, 300);
        v.setResizable(false);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setTitle("Ejercicio");
        v.add(p1);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(rbmejor.isSelected() == true){
            respuesta = Integer.toString(c.Mejor(Integer.parseInt(tftamaño.getText())));
            contador = Integer.toString(c.getcontador());
            lresecuacion = new JLabel("(5N^2 + 7N - 6)/2");
            
        }
        
        if(rbpeor.isSelected() == true){
            respuesta = Integer.toString(c.Peor(Integer.parseInt(tftamaño.getText())));
            contador = Integer.toString(c.getcontador());
            lresecuacion = new JLabel("6N^2 -3");
        }
        
        if(rbmedio.isSelected()==true){
            respuesta = Double.toString(c.Medio(Integer.parseInt(tftamaño.getText())));
            contador = Integer.toString(c.getcontador());
            lresecuacion = new JLabel("(17N^2 + 7N - 12)/4");
        }
        agregarRespuesta();
    }
    
    public void agregarRespuesta(){
        p1.removeAll();
        lresformula = new JLabel(respuesta);
        lrescontador = new JLabel(contador);
        lcomplejidad = new JLabel("La compejidad es N^2 (O^2)");
        lformula.setBounds(20, 210, 100, 30);
        lresformula.setBounds(140, 210, 100, 30);
        lcontador.setBounds(20, 240, 100, 30);
        lrescontador.setBounds(140, 240, 100, 30);
        lecuacion.setBounds(20, 270, 150, 30);
        lresecuacion.setBounds(180, 270, 150, 30);
        lcomplejidad.setBounds(20, 300, 200, 30);        
        v.setVisible(false);
        v.setSize(300, 370);
        v.setLocationRelativeTo(null);
        p1.add(ltamaño);
        p1.add(rbmedio);
        p1.add(rbmejor);
        p1.add(rbpeor);
        p1.add(bcalcular);
        p1.add(tftamaño);
        p1.add(lformula);
        p1.add(lresformula);
        p1.add(lcontador);
        p1.add(lrescontador);
        p1.add(lecuacion);
        p1.add(lresecuacion);
        p1.add(lcomplejidad);
        v.setVisible(true);
    } 
}
