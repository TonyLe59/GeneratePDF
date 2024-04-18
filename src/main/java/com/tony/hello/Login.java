package com.tony.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomProduit = request.getParameter("txtNom");
		String prix = request.getParameter("txtPrix");
		String quantite = request.getParameter("txtQuantite");

		if (nomProduit == null)
			nomProduit = "";
		if (prix == null)
			prix = "";
		if (quantite == null)
			quantite = "";

		HttpSession session = request.getSession();
		session.setAttribute("nomProduit", nomProduit);
		session.setAttribute("prix", prix);
		session.setAttribute("quantite", quantite);

		// Redirection vers la page de formulaire
		request.getRequestDispatcher("/Form.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomProduit = request.getParameter("txtNom");
		String prix = request.getParameter("txtPrix");
		String quantite = request.getParameter("txtQuantite");

		// Conversion des chaînes de caractères en nombres
		double prixDouble = Double.parseDouble(prix);
		int quantiteInt = Integer.parseInt(quantite);

		// Calcul du total TTC
		double totalHT = prixDouble * quantiteInt;
		double tauxTVA = 0.20;
		double montantTVA = totalHT * tauxTVA;
		double totalTTC = totalHT + montantTVA;

		HttpSession session = request.getSession();
		session.setAttribute("nomProduit", nomProduit);
		session.setAttribute("prix", prix);
		session.setAttribute("quantite", quantite);
		request.setAttribute("totalTTC", totalTTC);

		// Transférer le contrôle à la vue (JSP)
		request.getRequestDispatcher("Resultat.jsp").forward(request, response);

		if (nomProduit != null && prix != null && quantite != null) {
			request.getRequestDispatcher("/Form.jsp").forward(request, response);
			session.setAttribute("isConnected", true);
		} else {
			request.getRequestDispatcher("/Resultat.jsp").forward(request, response);
			session.setAttribute("isConnected", false);
		}

	}

}
