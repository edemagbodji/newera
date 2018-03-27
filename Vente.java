package com.newera.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Vente {

	private static double prixPomme = 0.6;
	private static double prixOrange = 1.25;
	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> listeDesAchats = new ArrayList<String>();
 
		sc = new Scanner(System.in);

		String nomArticle = "";
		String reponse = "OUI";

		while (reponse.equalsIgnoreCase("OUI")) {

			System.out.println("Entrer le nom de l'article acheté");
			nomArticle = sc.nextLine();

			while (!(nomArticle.equalsIgnoreCase("Pomme") || nomArticle.equalsIgnoreCase("Orange"))) {

				System.out.println("L'article entre n'est pas correct, Veuillez saisir de nouveau (Pomme/Orange)");

				nomArticle = sc.nextLine();
			}

			listeDesAchats.add(nomArticle);

			System.out.println("Voulez vous saisir un autre article ? (OUI/NON)");
			@SuppressWarnings("resource")
			Scanner scReponse = new Scanner(System.in);
			reponse = scReponse.nextLine();

			while (!(reponse.equalsIgnoreCase("OUI") || reponse.equalsIgnoreCase("NON"))) {
				System.out.println("Votre réponse est incorrete , saisissez de nouveau");
				reponse = scReponse.nextLine();
			}

		}

		System.out.println("Le prix total est  " + shoppingCart(listeDesAchats));
		

	}

	public static double shoppingCart(ArrayList<String> listeDesAchats) {

		double prixTotal = 0;

		for (int i = 0; i < listeDesAchats.size(); i++) {

			if (listeDesAchats.get(i).equalsIgnoreCase("Pomme")) {

				prixTotal = prixTotal + prixPomme;
			} else {
				prixTotal = prixTotal + prixOrange;
			}

		}

		return prixTotal;

	}

	public static double offreSimple(ArrayList<String> listeDesAchats) {

	/* POUR CETTE QUESTION NOUS NOUS BASONS SUR LE PRINCIPE SELON LEQUEL L'ACHETEUR AMENE UN CERTAIN NOMBRE 
	 * D'ORANGE ET DE POMME AU CONTOIRE POUR PAYS.
	 * NOUS SAISIRONS LES ARTICLES AMENES ET DEDUIRONS CE QU'IL DOIT PAYER SELON LES INDICATIONS DONNEES
	 * 
	 * */	
		
		
		int nombrePomme = 0;
		int nombreOrange = 0;
		double prixPomme = 0;
		double prixOrange = 0;
		double prixTotalPomme = 0;
		double prixTotalOrange = 0;
		;

		for (int i = 0; i < listeDesAchats.size(); i++) {

			if (listeDesAchats.get(i).equalsIgnoreCase("Pomme")) {

				nombrePomme++;
			} else

			{
				nombreOrange++;

			}

			if ((nombrePomme * 2) % 2 == 0) {

				prixTotalPomme = (nombrePomme) * prixPomme;
			} else {

				prixTotalPomme = (nombrePomme + 1) * prixPomme;

			}

			if (((nombreOrange * 2) / 3) % 2 == 0) {

				prixTotalOrange = (nombreOrange) * prixOrange;
			} else {

				prixTotalOrange = (nombreOrange + 1) * prixOrange;
			}

		}
		
		System.out.println("Le prix total des pommes : " + prixTotalPomme);
		System.out.println("Le prix total des Orange : " + prixTotalOrange);

		return prixTotalOrange + prixTotalPomme;

	}

}
