package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.NaveThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgNave1;
    private ImageIcon imgNave2;
    private ImageIcon imgNave3;
    private ImageIcon espaco;
    
    
    public Janela() {
        super();
               // ADICIONANDO ELEMENTOS AO FORMULÁRIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);
        
        this.setTitle("Corrida Espacial");
        espaco = new ImageIcon("./src/imagens/fundoEspaco.jpg");
        
        this.lblPista = new JLabel(espaco);
        this.lblPista.setBounds(0, 0, 1280, 650);
        this.add(lblPista);             
        this.lblPista.setBackground(Color.BLACK);
        this.btnCorrida = new JButton("Start Race");
        this.btnCancel = new JButton("Stop Race"); 
        this.btnCorrida.setBounds(300, 550, 120, 30);
        this.btnCancel.setBounds(900, 550, 120, 30);
                    
        imgNave1 = new ImageIcon("./src/imagens/nave3.png");
        imgNave2 = new ImageIcon("./src/imagens/nave4.png");
        imgNave3 = new ImageIcon("./src/imagens/nave5.png");
        
        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setVisible(true);

        this.repaint();

    }
     
     public JLabel JLabelNaves(String nome, ImageIcon img, int posX, int posY) {
        NaveThread carro = new NaveThread(nome, img, posX, posY);
        carro.setSize(256, 141);
        carro.setVisible(true);
        this.add(carro);
        return carro;
    }
          
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelNaves("Nave1", imgNave1, 0, 50));
            this.lblPista.add(JLabelNaves("Nave1", imgNave2, 0, 200));
            this.lblPista.add(JLabelNaves("Nave1", imgNave3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}