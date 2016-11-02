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
    
    List<Posicao> listaEstrelas = new ArrayList<Posicao>();
    GL2 Gl;
    
    public void criarEstrelas(int quant){
        
        Random r = new Random();
        int count = 0;
        
        while(count != quant){
            Posicao p = new Posicao(0,0,0);
            p.x = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt());
            p.y = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt()); 
            p.z = (r.nextInt(110)) * (float)Math.pow(-1, r.nextInt());
            
            if (Math.pow(Math.pow(p.x, 2) + Math.pow(p.y, 2) + Math.pow(p.z, 2), 1 / 3f) > 15)
                {
                    listaEstrelas.add(p);
                    count++;
                }
        }
    }
    
    public void desenhaEstrela(){
        Gl.glBegin(Gl.GL_POINTS);
            Gl.glColor3f(1, 1, 1);//Cor para pintar as estrelas 
            Gl.glPointSize(3); 
            
            for(Posicao pEstrela : listaEstrelas){
                Gl.glVertex3f(pEstrela.x, pEstrela.y, pEstrela.z);
            }
        Gl.glEnd();
    }
        
}
