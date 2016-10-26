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

public class JAsteroidsMain implements GLEventListener, KeyListener, MouseListener{
    
    private GLU glu;
    private GLUT glut;
    private double esqdir = 0, cimbaix = 0, dist = 0;
    
    //teste
    private double teste = 0;
    
    public static void main(String[] args) {
        
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("Nave");
        frame.setSize(600, 600);
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
        
        FPSAnimator animator = new FPSAnimator(canvas, 30);
        animator.start();
        
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        glu = new GLU();
        glut = new GLUT();
        gl.glClearColor(0.1f, 0.1f, 0.1f, 0f);
        gl.glClearDepth(1.0f);  
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
      
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        
        gl.glPushMatrix();
            gl.glScalef(1f, 1f, 1f);
            gl.glTranslatef((float)esqdir, (float)cimbaix, (float)dist);
            gl.glRotatef((float) teste, 0.0f, 1.0f, 0.0f);
            
            //foguete
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 3.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCylinder(1, 1, 8, 6);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 0.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 0.01f);
                gl.glTranslatef(0.0f, 0.0f, 300.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();

            //bico foguete
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, -0.75f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();
            
            //turbinas foguete
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (1.0f, 1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (-1.0f, 1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (0.0f, -1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            
            //flaps foguete
            gl.glPushMatrix();
                gl.glScalef(0.1f, 0.35f, -1.0f);
                gl.glTranslatef (0.0f, 3.0f, -2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(0.1f, 0.35f, -1.0f);
                gl.glTranslatef (0.0f, -3.0f, -2.5f);
                gl.glRotatef(45, 0.0f, 0.0f, 1.0f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
            
            
        
        gl.glPopMatrix();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        glu.gluPerspective(65.0, 600/600, 0.5, 200.0);
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
                moveDireita();
                break;
            case KeyEvent.VK_A:
                moveEsquerda();
                break;
            case KeyEvent.VK_W:
                moveCima();
                break;
            case KeyEvent.VK_S:
                moveBaixo();
                break;
            case KeyEvent.VK_NUMPAD1:
                teste1();
                break;
            case KeyEvent.VK_NUMPAD2:
                teste2();
                break;
        }//fim switch
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        
        switch(e.getButton())
        {
            case MouseEvent.BUTTON1:
                distanciaMais();
                break;
            case MouseEvent.BUTTON3:
                distanciaMenos();
                break;
        }//fim switch
    }   
    
    private void moveDireita() {
        esqdir = (esqdir + 0.5) % 360;
        System.out.println("TECLA D");
    }

    private void moveEsquerda() {
        esqdir = (esqdir - 0.5) % 360;
        System.out.println("TECLA A");
    }
    
    private void moveCima() {
        cimbaix = (cimbaix + 0.5) % 360;
        System.out.println("TECLA W");
    }
    
    private void moveBaixo() {
        cimbaix = (cimbaix - 0.5) % 360;
        System.out.println("TECLA S");
    }
    
    private void distanciaMenos() {
        dist = (dist + 0.5) % 360;
        System.out.println("BOTAO DIREITO");
    }
    
    private void distanciaMais() {
        dist = (dist - 0.5) % 360;
        System.out.println("BOTAO ESQUERDO");
    }
    
    private void teste1() {
        teste = (teste + 1) % 360;
        System.out.println("DEG = " + teste);
    }
    
    private void teste2() {
        teste = (teste - 1) % 360;
        System.out.println("DEG = " + teste);
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