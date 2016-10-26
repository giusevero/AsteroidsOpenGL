package jasteroids;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Lua {
    
    public void desenhaLua(GL2 gl, GLUT glut){
        gl.glPushMatrix();
            gl.glScalef(1.0f, 1.0f, 1.0f);
            gl.glTranslatef(20.0f, 20.0f, -10.0f);
            glut.glutWireSphere(5, 30, 10);
        gl.glPopMatrix();
    }
    
}
