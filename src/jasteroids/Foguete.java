package jasteroids;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Foguete{

    private double esqdir = 0, cimbaix = 0, dist = 0;
    //teste
    private double teste = 0;
  
    public void desenhaFoguete(GL2 gl, GLUT glut){
        gl.glPushMatrix();
            gl.glScalef(1f, 1f, 1f);
            gl.glTranslatef((float)esqdir, (float)cimbaix, (float)dist);
            gl.glRotatef((float) teste, 1.0f, 0.0f, 0.0f);
            
        //foguete
            //corpo
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 3.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCylinder(1, 1, 8, 6);
            gl.glPopMatrix();
            //base superior
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 0.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();
            //base inferior
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
            //direita superior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (1.0f, 1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            //esquerda superior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (-1.0f, 1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            //inferior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (0.0f, -1.0f, -3.25f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            
        //flaps foguete
            //superior
            gl.glPushMatrix();
                gl.glScalef(0.1f, 0.35f, -1.0f);
                gl.glTranslatef (0.0f, 3.0f, -2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glScalef(0.1f, 0.35f, -1.0f);
                gl.glTranslatef(3.0f, 0.0f, -2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
          
        gl.glPopMatrix();
    }
    
    public void moveDireita() {
        esqdir = (esqdir + 0.5) % 360;
        System.out.println("TECLA D");
    }

    public void moveEsquerda() {
        esqdir = (esqdir - 0.5) % 360;
        System.out.println("TECLA A");
    }
    
    public void moveCima() {
        cimbaix = (cimbaix + 0.5) % 360;
        System.out.println("TECLA W");
    }
    
    public void moveBaixo() {
        cimbaix = (cimbaix - 0.5) % 360;
        System.out.println("TECLA S");
    }
    
    public void distanciaMenos() {
        dist = (dist + 0.5) % 360;
        System.out.println("BOTAO DIREITO");
    }
    
    public void distanciaMais() {
        dist = (dist - 0.5) % 360;
        System.out.println("BOTAO ESQUERDO");
    }
    
    public void teste1() {
        teste = (teste + 1) % 360;
        System.out.println("DEG = " + teste);
    }
    
    public void teste2() {
        teste = (teste - 1) % 360;
        System.out.println("DEG = " + teste);
    }
    
}
