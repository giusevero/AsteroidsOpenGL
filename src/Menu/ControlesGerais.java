/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Elementos.Camera;
import Elementos.Estrela;
import Elementos.GeradorMeteoro;
import Elementos.Meteoro;
import Elementos.Nave;

/**
 *
 * @author Giu
 */
public class ControlesGerais {
    
    Camera camera = new Camera();
    Estrela estrela = new Estrela();
    Nave nave = new Nave();

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public Camera getCamera() {
        return camera;
    }
    
    public void comecaJogo(){
        
        GeradorMeteoro.GerarMeteoro(35, false);
    }
    
    public void reiniciaJogo(){
        
        GeradorMeteoro.GerarMeteoro(35, true);
        nave.Reiniciar();
    }
    
    public void criarObjetos(){
        estrela.criarEstrelas(450);
        nave.Criar();
        Meteoro.Criar();
    }
    
    public void desenhaCenario(){
        estrela.desenhaEstrela();
        GeradorMeteoro.DesenhaMeteoros();
        
    }
}
