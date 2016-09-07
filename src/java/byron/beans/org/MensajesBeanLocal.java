/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.beans.org;

import javax.ejb.Local;

/**
 *
 * @author byron
 */
@Local
public interface MensajesBeanLocal {

    public String enviarMensaje(String mensaje);
}
