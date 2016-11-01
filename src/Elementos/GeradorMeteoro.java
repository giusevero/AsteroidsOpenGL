/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Util.Posicao;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Giu
 */
public class GeradorMeteoro {
    
    static Random r = new Random();
    static ArrayList<Meteoro> listaMeteoro = new ArrayList<Meteoro>();
    
    public static void GerarMeteoro(int quant, boolean apagar){
        
        if(apagar==true){
            listaMeteoro.clear();
            
            for(int i = 0; i < quant; i++){
                listaMeteoro.add(new Meteoro());
            }
        }
    }
    
    public static boolean checarColisao(Posicao pNave, float raio){
        
        for(Meteoro meteor : listaMeteoro){
            Posicao pMeteoro = meteor.getP();
            if(Math.pow(Math.pow(pMeteoro.x - pNave.x, 2) + Math.pow(pMeteoro.y - pNave.y, 2) + Math.pow(pMeteoro.z - pNave.z, 2), 1 / 3f) < raio){
                if (meteor.impacto == false)
                    {
                        meteor.impacto = true;
                        return true; 
                    }
            }
        
        }
        return false;
    }
    
    public static void DesenhaMeteoros()
        {
            for(Meteoro meteor : listaMeteoro)
            {
                meteor.Desenha();  
            }
        }
}
