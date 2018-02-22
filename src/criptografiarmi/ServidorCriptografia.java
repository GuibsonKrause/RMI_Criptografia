package criptografiarmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gkrause
 */
public class ServidorCriptografia
{

    public static void main(String[] args)
    {
        try
        {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("criptoService", new CriptografiaImplemets());
            System.out.println("Servidor Iniciado");

        } catch (RemoteException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
