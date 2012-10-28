package mygame;



import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.network.Network;
import com.jme3.network.Server;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.JmeContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jme3.network.HostedConnection;
import com.jme3.network.serializing.Serializer;
import java.util.ArrayList;
import java.util.Collection;

/**
 * test
 * @author normenhansen
 */
public class ServerMain extends SimpleApplication {

    Server myServer = null;
    
    public static void main(String[] args) {
        ServerMain app = new ServerMain();
        app.start(JmeContext.Type.Headless); // headless type for servers!
    }

    @Override
    public void simpleInitApp() {
        
        try {
            myServer = Network.createServer(6143);
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        myServer.start();
        
        // Registrar cada tipo de mensaje
        Serializer.registerClass(HelloMessage.class);
        // ...
        
        // Registrar los Listeners de cada tipo de mensaje
        myServer.addMessageListener(new ServerListener(myServer), HelloMessage.class);
        // ...
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    // Necesitamos cerrar la conexión antes de apagar el server
    @Override
    public void destroy() {
      myServer.close();
      super.destroy();
    }
}
