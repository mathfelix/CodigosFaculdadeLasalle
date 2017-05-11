/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetormi;

import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author maycon Klopper
 */
public class Ativador 
{
    public static void main(String[] args) 
    {
        
        try {
            //cria o objeto da implementacao do servidor
            RMIServidor obj = new RMIServidor();
            //exporta o objeto para ser usado via RMI
            Servidor stub = (Servidor) UnicastRemoteObject.exportObject(obj,0);

            Registry registry;
            try {
                //se nao tiver um registry no ar cria um
                registry = LocateRegistry.createRegistry(1099);
            } catch(ExportException ee){
                //se deu esse erro e porque o registry ja estava no ar, entao so busca a referencia
                registry = LocateRegistry.getRegistry("127.0.0.1");
            }
            try{
                //registra o objeto no registry
                registry.bind("servidor", stub);
            } catch (AlreadyBoundException abe){
                //se ja existia no registry faz o bind com um numero aleatorio
                registry.bind("servidor"+Math.random(), stub);
            }
            System.out.println("Servidor esperando");
        } catch (Exception e) {
            System.err.println("erro:");
            e.printStackTrace();
        }
    }
}
