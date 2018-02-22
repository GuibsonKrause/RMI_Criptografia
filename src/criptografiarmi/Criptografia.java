package criptografiarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gkrause
 */
public interface Criptografia extends Remote
{

    public String criptografar(String a) throws RemoteException;

    public String descriptografar(String a) throws RemoteException;

}
