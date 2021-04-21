package castañeda_adriana_r5_u3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AthleticRaceInterface extends JFrame implements MouseListener{
    
    //Panel Registro
    public JLabel lblRegistrar = new JLabel("Registrar Corredor");
    public JTextField inputRegistro = new JTextField(30);
    public JButton btnRegistro = new JButton("Registrar");
    //Panel Corredores
    public JLabel lblCorredores =  new JLabel("Corredores Registrados");
    public JTextArea txtArea = new JTextArea(15,20);
    //Panel Resultados
    public JLabel lblResultados = new JLabel("Resultados");
    public JTextArea txtAreaResult = new JTextArea(20,25);
    public JButton btnIniciar = new JButton("Iniciar");
    public JButton btnReiniciar = new JButton("Reiniciar");
    public JButton btnTerminar = new JButton("Terminar");
    //DATOS
    Runner runners[] = new Runner[5];
    Integer contadorRunners = 0;
    
    
    
    public AthleticRaceInterface(){
        //Ventana
        setTitle("Carrera Atlética");
        setSize(900,855);
        setLayout(new GridLayout(3,1));
        //Panel Registro
        JPanel panelRegistro = new JPanel(new GridLayout(2,1));
            JPanel pr1 = new JPanel(new FlowLayout());
                pr1.add(lblRegistrar);
            JPanel pr2 = new JPanel(new FlowLayout());
                btnRegistro.addMouseListener(this);
                pr2.add(inputRegistro);
                pr2.add(btnRegistro);        
        panelRegistro.add(pr1);
        panelRegistro.add(pr2);
        
        JPanel panelCorredores = new JPanel(new GridLayout(2,1));
            JPanel pc1 = new JPanel(new FlowLayout());
                pc1.add(lblCorredores);
            JPanel pc2 = new JPanel(new FlowLayout());
                pc2.add(txtArea);
        panelCorredores.add(pc1);
        panelCorredores.add(pc2);
                
        JPanel panelResultados = new JPanel(new GridLayout(2,2));
            JPanel prs1 = new JPanel(new FlowLayout());
                prs1.add(lblResultados);
            JPanel prs2  = new JPanel(new GridLayout(1,2));
                prs2.add(txtAreaResult);
                JPanel prs3 = new JPanel(new GridLayout(3,1,3,3));
                    btnIniciar.addMouseListener(this);
                    btnReiniciar.addMouseListener(this);
                    btnTerminar.addMouseListener(this);
                    prs3.add(btnIniciar);
                    prs3.add(btnReiniciar);
                    prs3.add(btnTerminar);
                prs2.add(prs3);
        panelResultados.add(prs1);
        panelResultados.add(prs2);                                      
        //
        getContentPane().add(panelRegistro);
        getContentPane().add(panelCorredores);
        getContentPane().add(panelResultados);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj  = e.getSource();
        JButton btn = null;
        btn = (JButton)obj;
        
        //BOTON REGISTRAR
        if(btn.getText() == "Registrar"){
            String inputNombre = inputRegistro.getText();
            
            if(!inputNombre.isEmpty()){
                
                if(contadorRunners < 5){
                    
                    Runner nuevo = new Runner();
                    nuevo.setName(inputNombre);
                    nuevo.setSpeed();
                                                                 
                    runners[contadorRunners] = nuevo;
                                        
                    contadorRunners += 1;
                    inputRegistro.setText("");
                    
                    txtArea.append(contadorRunners.toString()  + "-" + runners[contadorRunners-1].getName() +".\n");
                    JOptionPane.showMessageDialog(null, "Corredor registrado con éxito.");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "El límimte de participantes se ha completado.");
                    inputRegistro.setText("");
                    //this.setTextArea();
                }                                
                               
            }else{
                JOptionPane.showMessageDialog(null, "El Corredor debe tener un nombre");
            }                        
        }
        
        //BOTÓN REINICIAR
        if(btn.getText() == "Reiniciar"){
            this.contadorRunners = 0;
            Arrays.fill(this.runners, null);
            txtArea.setText("");
            txtAreaResult.setText("");
        }
        //BOTÓN TERMINAR
        if(btn.getText() == "Terminar"){
            this.dispose();
        }
        //BOTÓN INICIAR
        if(btn.getText() == "Iniciar"){
            if(contadorRunners != 5){
                JOptionPane.showMessageDialog(null, "Aún no se han registrado todos los participantes.");
            }else{
                
                ThreadRunner r1 = new ThreadRunner(runners[0].getName(),runners[0].getSpeed(),txtAreaResult);
                ThreadRunner r2 = new ThreadRunner(runners[1].getName(),runners[1].getSpeed(),txtAreaResult);
                ThreadRunner r3 = new ThreadRunner(runners[2].getName(),runners[2].getSpeed(),txtAreaResult);
                ThreadRunner r4 = new ThreadRunner(runners[3].getName(),runners[3].getSpeed(),txtAreaResult);
                ThreadRunner r5 = new ThreadRunner(runners[4].getName(),runners[4].getSpeed(),txtAreaResult);
                Thread t1 = new Thread(r1);
                Thread t2 = new Thread(r2);
                Thread t3 = new Thread(r3);
                Thread t4 = new Thread(r4);
                Thread t5 = new Thread(r5);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
            }
        }
        
    }       
    
    public void setTextArea(){
        for(int i = 0; i <runners.length;i++){            
            txtArea.append("1-" + runners[i].getName() +".\n");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
