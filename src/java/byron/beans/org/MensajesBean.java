/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.beans.org;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 *
 * @author byron
 */
@Stateless
public class MensajesBean implements MensajesBeanLocal {

    @Resource(mappedName = "jms/MainQueue")
    private Queue mainQueue;

    @Inject
    @JMSConnectionFactory("jms/MainConnectionFactory")
    private JMSContext context;

    private void sendJMSMessageToMainQueue(String messageData) {
        JMSProducer producer = context.createProducer();
        producer.send(mainQueue, messageData);
    }

    @Override
    public String enviarMensaje(String mensaje) {

        sendJMSMessageToMainQueue(mensaje);

        return "Enviado OK";

    }
}
