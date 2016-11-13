package Menu;

import jasteroidsv2.JAsteroidsFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame{
    
    public void iniciaMenu(){
        super.setSize(736,460);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setTitle("JAsteroids V2");
        try {
            adicionaBackground();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            adicionaIcone();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        adicionaComponentes();
        
        super.setVisible(true);
    }
    
    private void adicionaComponentes(){
        
        JButton bt1 = new JButton("Iniciar");
        bt1.setBounds(590,235,100,40);
        super.add(bt1);
        
        JButton bt2 = new JButton("Ajuda");
        bt2.setBounds(590,295,100,40);
        super.add(bt2);
        
        JButton bt3 = new JButton("Sair");
        bt3.setBounds(590,355,100,40);
        super.add(bt3);
        
        JLabel lb1 = new JLabel("versão 2.1.0");
        lb1.setForeground(Color.gray.darker());
        lb1.setBounds(655,5,70,15);
        super.add(lb1);
        
        JLabel lb2 = new JLabel("Produzido por Arthur C. e Giugliano S.");
        lb2.setForeground(Color.cyan.darker().darker());
        lb2.setBounds(515,415,230,15);
        super.add(lb2);
        
        ButtonHandler handler = new ButtonHandler();
        bt1.addActionListener(handler);
        bt2.addActionListener(handler);
        bt3.addActionListener(handler);
        
    }
    
    private void iniciaJogo(){  
        JAsteroidsFrame jast = new JAsteroidsFrame();    
        jast.start();
    }
    
    private void abreAjuda(){
        JLabel lbAjuda = new JLabel("<html>W - Sobe <br>S - Desce <br>A - Esquerda <br>D - Direita <br>"+
                "Botão esquerdo do mouse acelera <br>"+
                "Botão direito do mouse desacelera <br> </html>", JLabel.CENTER);
        
        JOptionPane.showMessageDialog(null, lbAjuda, "Ajuda", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void abreSair(){
    int sair = JOptionPane.showOptionDialog(null, 
        "Deseja realmente sair do jogo?", 
        "Aviso", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, null, null);

    if (sair == JOptionPane.YES_OPTION)
        System.exit(0);
        
    }
    
    private void adicionaIcone() throws IOException{
        BufferedImage icone = ImageIO.read(getClass().getResource("/Imagens/Icone.png"));
        super.setIconImage(icone);
    }
    
    private void adicionaBackground() throws IOException{
        BufferedImage fundo = ImageIO.read(getClass().getResource("/Imagens/Background.jpg"));
        super.setContentPane(new ImagePanel(fundo));
    }
    
    //classe para pintar o bg do menu
    class ImagePanel extends JComponent {
            private Image imagem;

            public ImagePanel(Image imagem) {
                this.imagem = imagem;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagem, 0, 0, this);
        }
    }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand() == "Iniciar"){
                dispose();
                iniciaJogo();
            }
            else if(e.getActionCommand() == "Ajuda")
                abreAjuda();
            else if(e.getActionCommand() == "Sair")
                abreSair();
        }
   }
    
}
