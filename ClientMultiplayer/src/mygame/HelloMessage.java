/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 *
 * @author Mark
 */
@Serializable
public class HelloMessage extends AbstractMessage {
    
  private String message;       // custom message data
  
  public HelloMessage(){}
  
  public HelloMessage(String s) { 
      message = s; 
  } 
  
  public String getMessage(){
      return message;
  }
}