/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Util.Posicao;
import com.jogamp.opengl.GL2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Giu
 */
public class Estrela {
    
    List<Posicao> listaEstrelas = new ArrayList<>();
    
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = 0.0f;
    
    
    public void criarEstrelas(int quant){
        
        Random r = new Random();
        int count = 0;
        
        while(count != quant){
            Posicao p = new Posicao(0,0,0);
            posX = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt());
            posY = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt()); 
            posZ = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt());
            
            if (Math.pow(Math.pow(posX, 2) + Math.pow(posY, 2) + Math.pow(posZ, 2), 1 / 3f) > 15)
                {
                    listaEstrelas.add(p);
                    count++;
                }
        }
    }
    
    public void desenhaEstrela(GL2 Gl){
        Gl.glBegin(GL2.GL_POINTS);
            Gl.glColor3f(1, 1, 1);//Cor para pintar as estrelas 
            Gl.glPointSize(3); 
            
            for(Posicao pEstrela : listaEstrelas){
                Gl.glVertex3f(posX, posY, posZ);
            }
        Gl.glEnd();
    }
        
}
