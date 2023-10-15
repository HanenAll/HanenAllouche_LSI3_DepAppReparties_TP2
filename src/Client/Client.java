package Client;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	//activite 2.1

		public static void main(String[] args)  {
			try{
				System.out.println("je suis un client");
			    Socket socket=new Socket("Localhost",1234); // une socket va etre crée 
			    // localhost c'est la machine du client et 1234 c'est le port
			    //cette instruction est pour la demande de connexion de client au serveur 
			    System.out.println("je suis un client connecté");
			    InputStream is = socket.getInputStream(); // elle lu le flux qui est dans le port 1234
			    OutputStream os = socket.getOutputStream(); // elle fait sortie le contenue de is et le renvoi au serveur
			    PrintWriter pw= new PrintWriter(os,true); //PrintWriter nous permet d'envoyer la chaine de caractere caractere par caractere
			    Scanner scanner= new Scanner(System.in); // je donne la main au utilisateur d'ecrire une valeur
			    System.out.println("donner la 1ere valeur");
			    int nb1=scanner.nextInt(); // nextInt elle lu un entier
			    System.out.println("donner la 2ere valeur");
			    int nb2=scanner.nextInt();
			    String op;
			    do {
			         System.out.println("donner l'operateur (+,-,/,%)");
			          op=scanner.nextLine(); // nextLine elle lu un String
			       }
			    while(!op.equals("+")&& !op.equals("-")&& !op.equals("/")&& !op.equals("%"));
			    pw.println(nb1);pw.println(nb2); pw.println(op); //pw elle concatine le type par defaut en string  
			    //on a separer les 3 operateurs pour faciliter le travail cote serveur 
		        InputStreamReader isr=new InputStreamReader(is); // InputStreamReader lu 4 octect , elle fait appel 4 fois au InputStream 
		        BufferedReader br= new BufferedReader(isr);// BufferedReader collecte toute la chaine envoyer par le serveur qui le res
		        System.out.println(nb1+""+op+""+nb2+"= "+br.readLine());
			    System.out.println("deconnexion client");
		        socket.close();
			}
			catch(Exception e) {e.printStackTrace();};
		}
	}

