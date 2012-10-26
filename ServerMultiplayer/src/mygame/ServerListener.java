package mygame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

/**
 *
 * @author Mark
 */
public class ServerListener implements MessageListener<HostedConnection> {
    
  public void messageReceived(HostedConnection source, Message message) {
    if (message instanceof HelloMessage) {
      // do something with the message
      HelloMessage helloMessage = (HelloMessage) message;
      System.out.println("Server received '" +helloMessage.getMessage() +"' from client #"+source.getId() );
    } // else....
  }

}