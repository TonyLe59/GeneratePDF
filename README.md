PDF Generator with Java EE and Servlets

Description

Ce projet est une application web développée en Java EE utilisant Servlets pour générer des fichiers PDF à partir des entrées utilisateur. L'application prend un nom de produit, un prix et une quantité, calcule le total TTC, et génère un fichier PDF téléchargeable.

Technologies Utilisées

Java EE (Servlets, HTTP Sessions)

iTextPDF (pour la génération de PDF)

JSP (pour la gestion de l'affichage)

Tomcat (serveur d'application)

Fonctionnalités

Formulaire de saisie des informations produit

Calcul automatique du Total TTC avec TVA (20%)

Génération et téléchargement d'un fichier PDF contenant les détails du produit

Gestion de session pour conserver les données de l'utilisateur

Installation & Configuration

1. Prérequis

Assurez-vous d'avoir installé les outils suivants :

JDK 8+

Apache Tomcat 9+

Maven (optionnel, pour la gestion des dépendances)

2. Cloner le projet

git clone https://github.com/votre-utilisateur/votre-repo.git
cd votre-repo

3. Ajouter la dépendance iTextPDF

Si vous utilisez Maven, ajoutez cette dépendance dans pom.xml :

<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.2</version>
</dependency>

Sinon, téléchargez iTextPDF.jar et ajoutez-le au WEB-INF/lib.

4. Déploiement

Compilez et exportez le projet sous forme de WAR.

Déployez le fichier .war sur Tomcat (webapps/).

Démarrez Tomcat et accédez à l'application via :

http://localhost:8080/nom-du-projet

Structure du Code

/ votre-projet
  ├── src/
  │   ├── com/tony/hello/
  │   │   ├── GeneratePDF.java  # Servlet de génération du PDF
  │   │   ├── Login.java        # Gestion des sessions utilisateur
  │   │   ├── MyServletContext.java  # Listener pour logs
  ├── WebContent/
  │   ├── Form.jsp   # Formulaire de saisie des produits
  │   ├── Resultat.jsp   # Affichage des résultats
  ├── WEB-INF/
  │   ├── web.xml  # Configuration du projet
  ├── pom.xml  # Configuration Maven (si applicable)

Utilisation

Accédez à Form.jsp pour entrer un produit.

Cliquez sur Générer PDF.

Le fichier PDF sera généré et proposé en téléchargement.

Auteur

Lefebvre Tony
