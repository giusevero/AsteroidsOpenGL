/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Util.Posicao;
import java.util.ArrayList;
import java.util.Random;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.util.List;

/**
 *
 * @author Giu
 */
public class GeradorMeteoro {
    
    static Random r = new Random();
    static List<Meteoro> listaMeteoro= new ArrayList<Meteoro>() ;
    Foguete fog = new Foguete();
    
    public void GerarMeteoro(GLAutoDrawable drawable, int quant, boolean apagar){
        
        //listaMeteoro = new ArrayList<Meteoro>();
        if(apagar==true){
            listaMeteoro.clear();
        }else{
            for(int i = 0; i < 1; i++){
                listaMeteoro.add(new Meteoro(drawable));
            }
            System.out.println(" "+listaMeteoro.size());
        }
    }  
    
    public void GeraMeteoro(GLAutoDrawable drawable, int quant){
        
        if(quant % 30 == 0){
            listaMeteoro.add(new Meteoro(drawable));
            System.out.println(" "+listaMeteoro.size());
        }
        
    }  
    
//    public boolean checarColisao(Foguete fog, float raio){
//        
//        for(Meteoro meteor : listaMeteoro){
//            if(Math.pow(Math.pow(meteor.getPosX() - fog.getPosX(), 2) + Math.pow(meteor.getPosY() - fog.getPosY(), 2) + Math.pow(meteor.getPosZ() - fog.getPosZ(), 2), 1 / 3f) < raio){
//                if (meteor.impacto == false)
//                    {
//                        meteor.impacto = true;
//                        return true; 
//                    }
//            }
//        
//        }
//        return false;
//    }
    
    public boolean checarColisao(Foguete fog){
        Boolean impacto=false;
        for(Meteoro meteor : listaMeteoro){
            //Math.Pow(pAsteroide.x - pNave.x, 2) + Math.Pow(pAsteroide.y - pNave.y, 2) + Math.Pow(pAsteroide.z - pNave.z, 2), 1 / 3f
           // Math.pow(Math.pow(meteor.getPosX()-fog.getPosX(), 2)+ Math.pow(meteor.getPosY()-fog.getPosY(), 2) + Math.pow(meteor.getPosZ()-fog.getPosZ(), 2),2/3f)
            if(meteor.getPosX() == fog.getPosX() && meteor.getPosY()==fog.getPosY() && meteor.getPosZ()==fog.getPosZ()){
                impacto= meteor.impacto=true;
                System.out.println("Bateu!");
            }else{
                impacto=meteor.impacto =false;
            }
        }
        return impacto;
    }
    public void DesenhaMeteoros(GL2 Gl)
        {
            for(Meteoro meteor : listaMeteoro)
            {
                meteor.Desenha(Gl);  
                //System.out.println("PosX "+meteor.getPosX()+ "PosY "+meteor.getPosY()+ "PosZ "+meteor.getPosZ());
            }
        }
}
