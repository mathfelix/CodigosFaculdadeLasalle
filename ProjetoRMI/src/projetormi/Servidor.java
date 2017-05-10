/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetormi;

import java.net.Socket;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author maycon Klopper
 */
public interface Servidor extends Remote
{
    public void carregarArquivo(String nome, String caminho) throws RemoteException;
    public void escreverArquivos(String[] op2) throws RemoteException;
    public void descarregarLista() throws RemoteException;
    public void capturaBytes(String nome, byte[] cbuffer) throws RemoteException;
}
