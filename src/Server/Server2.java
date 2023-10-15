package Server;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Client.Operation;

public class Server2 {
	//activite 2.2
		public static void main(String[] args)  {
	      try {
	    	  System.out.println("je suis un serveur");
	          ServerSocket serverSocket = new ServerSocket(1234); //on a fait une réservation du port
	          System.out.println("je suis un serveur , j'atend un client");
	          Socket socket=serverSocket.accept();// elle accepte la demande de connexion du client et 
	          //L'attribut socket va retourner une image de type socket.
	          //la methode accepte() bloque l'execution jusqu'a un client est connecté 
	          System.out.println("un client est connecté");
	          //traitement
	          // les 2 methode inputstream() et outputstream() sont 2 methodes d'echange de données avec le client
	          InputStream is = socket.getInputStream(); // inputStram reçue les données deja sérialisées coté clent 
	          OutputStream os = socket.getOutputStream(); 
	          ObjectInputStream ois= new ObjectInputStream(is);//ObjectInputStream est utilisé pour désérialiser les données reçues 
	          //à partir de l'inputStream 
	          Operation op=(Operation)ois.readObject();//readObject() elle lu l'objet sérialisé à partir du flux d'entrée 'ois' et
	          // le renvoit de type object c pour cela on a utiliser le casting pour le convertir en type operation
	          int res;
	          switch(op.getOperation()) {
	          case '+': res=op.getOp1()+op.getOp2();break;
	          case '-': res=op.getOp1()-op.getOp2();break;
	          case '/': res=op.getOp1()/op.getOp2();break;
	          case '%': res=op.getOp1()%op.getOp2();break;
	          default : res = 0;
	          }
	          ObjectOutputStream ooos= new ObjectOutputStream(os);
	          Operation opp=new Operation(op.getOp1(),op.getOp2(),op.getOperation());
	          opp.setResult(res);
	          ooos.writeObject(opp);
	          System.out.println("deconnexion serveur");
	          socket.close();
	          serverSocket.close(); //libération de tout ce qui est reservé
	      }
	      catch(Exception e) {e.printStackTrace();}
		}
}
	