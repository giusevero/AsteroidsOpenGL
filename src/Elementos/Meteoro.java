/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Util.Posicao;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giu
 */
public class Meteoro {
    
     //Variáveis
    static int lista;
    Random r = new Random();
    Posicao p;
    float incX;
    float incY;
    float velocidade;
    float raio;
    float rotacao;
    
    boolean impacto;
    
   Texture textura;
   TextureData textura1;
   TextureData textura2;
    
    
    static GL2 Gl; 
    static GLU Glu;
    GLUT glut;

    public Posicao getP() {
        return p;
    }

    public void setP(Posicao p) {
        this.p = p;
    }

    public boolean isImpacto() {
        return impacto;
    }

    public void setImpacto(boolean impacto) {
        this.impacto = impacto;
    }

    public Meteoro(){
        
       p = new Posicao(0, 0, 0);
       rotacao = r.nextInt(90);
       Reset();
      
       
       
        try {
            InputStream stream1 = getClass().getResourceAsStream("/Texturas/asteroide1.jpg");
            textura1 = TextureIO.newTextureData(GLProfile.getDefault(), stream1, false, "jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro na textura 1 "+ex.getMessage());
        }
        
           
        try {
             InputStream stream2 = getClass().getResourceAsStream("/Texturas/asteroide1.jpg");
              textura2 = TextureIO.newTextureData(GLProfile.getDefault(), stream2, false, "jpg");
        } catch (IOException ex) {
             ex.printStackTrace();
            System.out.println("Erro na textura 2 "+ex.getMessage());
        }
            if(r.nextInt(2)==1){
 
                this.textura = TextureIO.newTexture(textura1);
            }else{
           
                this.textura = TextureIO.newTexture(textura2);
            }
        
           
    }
    
   
     public void Reset() {
        
     p.x = (r.nextInt(11))*(float)Math.pow(-1, r.nextInt());
     p.y = (r.nextInt(9)) * (float)Math.pow(-1, r.nextInt());
     p.z = (35+ (r.nextInt(35))) * -1;
     raio = (float)(r.nextDouble() * 2);
     
     if (p.x > 0)
                incX = (float)r.nextDouble() * -1;
            else
                incX = (float)r.nextDouble();

            if (p.y > 0)
                incY = (float)r.nextDouble() * -1;
            else
                incY = (float)r.nextDouble();

            incX *= 0.03f;
            incY *= 0.03f;
            velocidade = (float)(r.nextDouble() * 0.1); 
     }
    
     static public void Criar()
        {
            GLUquadric quadratic = Glu.gluNewQuadric(); //Criar o objeto quadrico
            Glu.gluQuadricNormals(quadratic, Glu.GLU_SMOOTH);
            Glu.gluQuadricTexture(quadratic, Boolean.TRUE);
            
            
            lista = Gl.glGenLists(1); // Cria a lista 
            Gl.glNewList(lista, Gl.GL_COMPILE);
                Gl.glPushMatrix();
                Gl.glRotated(270, 1, 0, 0);
                Glu.gluSphere(quadratic, 1, 5, 5); //Criou a esfera 
            Gl.glPopMatrix();
            Gl.glEndList();
        }

        public void Desenha()
        {
            p.z += velocidade;
            p.y += incY;
            p.x += incX;
            rotacao += 1f;

            textura.enable(Gl);
            textura.bind(Gl);
 
            Gl.glPushMatrix();
                Gl.glTranslatef(p.x, p.y, p.z);    
                Gl.glRotatef(rotacao, 1, 1, 1); 
                Gl.glCallList(lista);  
            Gl.glPopMatrix();

            if (p.z > 4)
            {
                Reset();  
            }
            textura.disable(Gl);
            textura.destroy(Gl);
        }
}
