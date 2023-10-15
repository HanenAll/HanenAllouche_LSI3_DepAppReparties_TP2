package Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//activite 2.1
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
	          InputStream is = socket.getInputStream(); // elle lu l'octet envoyer par le client
	          OutputStream os = socket.getOutputStream(); 
	          int nb1,nb2,res; String op;
	          InputStreamReader isr= new InputStreamReader(is); //elle lu 4 octects 
	          BufferedReader br= new BufferedReader(isr); //Bufferedreader collecte toute la chaine
	          nb1=Integer.parseInt(br.readLine()); 
	          nb2=Integer.parseInt(br.readLine());
	          op=br.readLine();//br.readline() elle lu l'operateur 
	          switch(op) {
	          case "+": res=nb1+nb2;break;
	          case "-": res=nb1-nb2;break;
	          case "/": res=nb1/nb2;break;
	          case "%": res=nb1%nb2;break;
	          default : res = 0;
	          }
	          PrintWriter pw=new PrintWriter(os,true);
	          pw.println(res);
	          System.out.println("deconnexion serveur");
	          socket.close();
	          serverSocket.close(); //libération de tout ce qui est reservé
	      }
	      catch(Exception e) {e.printStackTrace();}
		}
}
