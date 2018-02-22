package criptografiarmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author gkrause
 */
public class ClienteCriptografia
{

    public static void main(String[] args)
    {
        String A, resp = "";
        //Faz uma pergunta Sim = 0 ou Não = 1
        int opcao = JOptionPane.showConfirmDialog(null, "Sim = Criptografia"
                + "\nNão = Descriptografia", "Escolha uma opção", 0);
        try
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            Criptografia cripto = (Criptografia) myRegistry.lookup("criptoService");

            if (opcao == 0)
            {
                A = JOptionPane.showInputDialog("Entre com o texto. Sem Acento");
                resp = cripto.criptografar(A);
            } else
            {
                A = JOptionPane.showInputDialog("Entre com o texto. Sem Acento");
                resp = cripto.descriptografar(A);
            }
        } catch (RemoteException re)
        {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe)
        {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (ArithmeticException ae)
        {
            System.out.println();
            System.out.println("ArithmeticException");
            System.out.println(ae);
        } catch (StringIndexOutOfBoundsException str)
        {
            System.out.println();
            System.out.println("StringIndexOutOfBoundsException");
            System.out.println(str);
        } catch (ArrayIndexOutOfBoundsException arr)
        {
            System.out.println();
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println(arr);
        }

        JTextArea outputArea = new JTextArea();
        outputArea.setText(resp);

        JOptionPane.showMessageDialog(null, outputArea, "Texto Criptografado",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
