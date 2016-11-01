package jasteroidsv2;

import Elementos.Foguete;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class HandlersJogo implements KeyListener, MouseListener{

    private JAsteroidsRender render;
    private Foguete fog;
    
    public HandlersJogo(JAsteroidsRender render){
        this.render = render;
        fog = this.render.getFog();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == e.VK_A) {
            fog.setPosX(fog.getPosX()+0.5f);
            System.out.println("A");
        }
        if (e.getKeyCode() == e.VK_D) {
            fog.setPosX(fog.getPosX()-0.5f);
            System.out.println("D");
        }
        if (e.getKeyCode() == e.VK_W) {
            fog.setPosY(fog.getPosY()+0.5f);
            System.out.println("W");
        }
        if (e.getKeyCode() == e.VK_S) {
            fog.setPosY(fog.getPosY()-0.5f);
            System.out.println("S");
        }
        if (e.getKeyCode() == e.VK_Z) {
            fog.setPosZ(fog.getPosZ()+0.5f);
            System.out.println("Z");
        }
        if (e.getKeyCode() == e.VK_X) {
            fog.setPosZ(fog.getPosZ()-0.5f);
            System.out.println("X");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()== MouseEvent.BUTTON1) {
            fog.setPosZ(fog.getPosZ()+0.5f);
            System.out.println("MOUSE1");
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            fog.setPosZ(fog.getPosZ()-0.5f);
            System.out.println("MOUSE3");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


}
