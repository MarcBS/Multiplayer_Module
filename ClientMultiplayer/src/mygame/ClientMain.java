package mygame;

import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.JmeContext;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * test
 * @author normenhansen
 */
public class ClientMain extends SimpleApplication implements ActionListener {
    
    Client myClient = null;

    public static void main(String[] args) {
        ClientMain app = new ClientMain();
        app.start(JmeContext.Type.Display); // standard display type
    }

    @Override
    public void simpleInitApp() {
        
        try {
            myClient = Network.connectToServer("localhost", 6143);
        } catch (IOException ex) {
            Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        myClient.start();
        
        // Registrar cada tipo de mensaje
        Serializer.registerClass(HelloMessage.class);
        // ...
        
        // Registrar los Listeners de cada tipo de mensaje
        myClient.addMessageListener(new ClientListener(), HelloMessage.class);
        // ...
        
        
        inputManager.addMapping("Key_M", new KeyTrigger(KeyInput.KEY_M));
        inputManager.addListener(this, "Key_M");
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    // Necesitamos cerrar la conexión antes de apagar el cliente
     @Override
     public void destroy() {
         // custom code
         myClient.close();
         super.destroy();
     }

    public void onAction(String name, boolean isPressed, float tpf) {
        if(name.equals("Key_M") && !isPressed){
                Message message = new HelloMessage("Hello World!");
                myClient.send(message);
        }
    }
}
