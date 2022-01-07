package utilitaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

public class Communication {

	public static Gson gson = new Gson();

	public static final String demandeCreationMsg = "Demande creation message", demandeCreationFil = "Demande creation fil",
			demandeTousFils = "Demande tous les fils", demandeFil = "Demande get fil",
			demandeTousGroupes = "Demande tous les groupes", demandeGroupeUtilisateur = "Demande groupe utilisateur";

	public static void log(String msg) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  		
		System.out.println(formatter.format(date) + " : " + msg);
	}

	public static int envoyerMsg(BufferedWriter os, String msg) {
		try {
			os.write(msg);
			os.newLine();
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

	public static String lireMsg(BufferedReader is) {
		String responseLine;
		try {
			responseLine = is.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return responseLine;

	}

}
