package jasteroidsv2;

import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JLabel;

public class JAsteroidsFrame{

    public void start(){
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        JFrame frame = new JFrame("JAsteroids");
        frame.setSize(950,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        JAsteroidsRender jogo = new JAsteroidsRender();
        HandlersJogo act = new HandlersJogo(jogo);

        canvas.addGLEventListener(jogo);
        canvas.addKeyListener(act);
        canvas.addMouseListener(act);
        canvas.setVisible(true);
        
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
    
}
