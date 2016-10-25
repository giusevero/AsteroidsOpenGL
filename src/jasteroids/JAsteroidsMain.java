package jasteroids;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

public class JAsteroidsMain implements GLEventListener, KeyListener{
    
    private GLU glu;
    private GLUT glut;
    private int nave = 0;
    
    public static void main(String[] args) {
        
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("Boneco");
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
        gl.glRotatef((float) nave, 0.0f, 0.0f, 1.0f);
        
        gl.glPushMatrix();
        gl.glScalef(1.0f, 2.0f, 0.6f);
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        glut.glutWireCube(1.5f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef (1.0f, 1.6f, 0.0f);
        glut.glutWireCube(0.3f);
        gl.glPopMatrix();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        glu.gluPerspective(65.0, 600/600, 1.0, 20.0);
        gl.glTranslatef(0.0f, 0.5f, -10.0f);
        
    }

    @Override
    public void keyTyped(KeyEvent key) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent key) {
        
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_D:
                rotaDireita();
                break;
            case KeyEvent.VK_A:
                rotaEsquerda();
                break;
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent key) {
        
    }
    
    private void rotaDireita() {
        nave = (nave - 3) % 360;
    }

    private void rotaEsquerda() {
        nave = (nave + 3) % 360;
    }
    
}