/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.turnos.org;

import byron.beans.org.MensajesBeanLocal;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author byron
 */
@WebService(serviceName = "TurnosWS")
public class TurnosWS {

    @Inject
    MensajesBeanLocal sender;

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {

        String res;

        res = sender.enviarMensaje(txt);

        return "Mensaje: " + res + " !";
    }
}
