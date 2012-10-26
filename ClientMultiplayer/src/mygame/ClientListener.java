/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

/**
 *
 * @author Mark
 */
public class ClientListener implements MessageListener<Client> {
    

  public void messageReceived(Client source, Message message) {
    if (message instanceof HelloMessage) {
      // do something with the message
      HelloMessage helloMessage = (HelloMessage) message;
      System.out.println("Client #"+source.getId()+" received: '"+helloMessage.getMessage()+"'");
    } // else...
  }
    
}

