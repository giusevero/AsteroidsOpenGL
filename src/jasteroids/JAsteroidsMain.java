package jasteroids;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.swing.JFrame;

public class JAsteroidsMain implements GLEventListener, KeyListener, MouseListener{
    
    private Foguete fog;
    private Lua lua;
    private GLU glu;
    private GLUT glut;
    
    public static void main(String[] args) {
        
        JFrame menu = new JFrame("JAsteroids");
        menu.setSize(320, 480);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
        
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("Nave");
        frame.setSize(950, 700);
        frame.add(canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        JAsteroidsMain jogo = new JAsteroidsMain();
        canvas.addGLEventListener(jogo);
        canvas.addKeyListener(jogo);
        canvas.addMouseListener(jogo);
        canvas.setVisible(true);
        
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
        
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        glu = new GLU();
        glut = new GLUT();
        gl.glClearColor(0.1f, 0.1f, 0.1f, 0f);
        gl.glClearDepth(1.0f);  
        
        fog = new Foguete();
        lua = new Lua();
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
      
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL2 gl = drawable.getGL().getGL2();
        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        
        fog.desenhaFoguete(gl, glut);
        lua.desenhaLua(gl, glut);
        
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        glu.gluPerspective(90.0, 1, 0.5, 200.0);
        gl.glTranslatef(0.0f, -1.0f, -8.0f);
        
    }

    @Override
    public void keyPressed(KeyEvent key) {
       
        switch (key.getKeyCode()) 
        {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                System.out.println("TECLA ESC");
                break;
            case KeyEvent.VK_D:
                fog.moveDireita();
                break;
            case KeyEvent.VK_A:
                fog.moveEsquerda();
                break;
            case KeyEvent.VK_W:
                fog.moveCima();
                break;
            case KeyEvent.VK_S:
                fog.moveBaixo();
                break;
            case KeyEvent.VK_NUMPAD1:
                fog.teste1();
                break;
            case KeyEvent.VK_NUMPAD2:
                fog.teste2();
                break;
        }//fim switch
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                fog.distanciaMais();
                break;
            case MouseEvent.BUTTON3:
                fog.distanciaMenos();
                break;
        }//fim switch
        
    }   

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    
}