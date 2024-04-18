package com.tony.hello;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class GeneratePDF
 */
@WebServlet("/GeneratePDF")
public class GeneratePDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneratePDF() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		System.out.println("Nom Produit: " + nomProduit);
		System.out.println("Prix: " + prix);
		System.out.println("Quantité: " + quantite);
		System.out.println("Total TTC: " + totalTTC);

		HttpSession session = request.getSession();
		session.setAttribute("nomProduit", nomProduit);
		session.setAttribute("prix", prix);
		session.setAttribute("quantite", quantite);
		session.setAttribute("resultatTTC", totalTTC);

		// Génération du contenu du PDF

		  Document document = new Document();
	        try {
	        	PdfWriter.getInstance(document, response.getOutputStream());
	            document.open();
	            document.add(new Paragraph("Nom Produit : " + nomProduit));
	            document.add(new Paragraph("Prix : " + prix));
	            document.add(new Paragraph("Quantité : " + quantite));
	            document.add(new Paragraph("Total TTC : " + totalTTC));
	            document.close();

		//System.out.println("Contenu du PDF: \n" + pdfContent.toString());

		// Configuration de l'en-tête de réponse pour indiquer un contenu PDF

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=results.pdf");

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
