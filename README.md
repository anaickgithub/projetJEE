# projetJEE
# MIGUET Anaïck et LEQUIN Nicolas

Cette application a pour but de réduire des url afin de faciliter la navigation.


pour faire tourner cette application il est nécessaire d'ajouter les information de connection de sa bdd dans le fichier :
projetjee-core/src/main/resources/db.properties tel que :

driverClass=com.mysql.jdbc.Driver		//Nom du driver de base de donné, ici mysql
jdbcUrl=jdbc:mysql://localhost:3306/projetjee	//Chemin de la base de donné, avec ici une bdd nomé projetjee
username=root					//Nom d'utilisateur de votre bdd, root par défault
password=!L7!&NZJ]wURza				//Mot de passe de votre bdd, null par défault

L'appliction est multimodule, tel que dans le tp06 :

projetjee-assets répertoriant le front end (html (transformer en .vm pour fonctionner avec spring), css, javascript).
projetjee-core répertoriant le coeur de l'application (entité, DAO, config(connection à la bdd), service).
projetjee-web répertoriant les controller (RestController pour le webservice et HomeController pour les différente fonctionnalité de la page home.vm) de l'application ainsi que la configuration web (WebConfig comme vu dans le tp04) et webservice Rest (WSConfig vu dans le tp06).

L'application s'articule autour d'une classe principale URLPerso composé :

- Un id
- url (url d'origine)
- urlCourt (url raccourci)
- perso (booléen qui prend la valeur 1 si l'utilisateur à rentré lui même son url raccourci)


L'application permet à l'utilisateur de consulter sa liste d'URL déjà enregristré sur l'application et de consulter les sites en question en cliquant sur les liens ou en rentrant directement l'URL raccourci dans l'URL du navigateur
De plus il peut ajouter un nouvelle URL à la base de données en choisissant ou non si l'URL raccourci sera généré aléatoirement ou si il veut choisir lui même son nom.
Si l'URL est généré automatiquement l'algorithme va agir comme suis :

premier url généré : a, puis b, c, d, ... arrivé à z le prochain sera aa, bb, cc, ..., zz puis aaa, ...

L'utilisateur peut ensuite supprimer un url en cliquant sur la croix rouge à droite de chaque ligne de l'url correspondant.

Pour l' API Rest :
http://localhost:8080/api permet de renvoyer le même tableau que dans l’interface WEB, mais au format JSON
http://localhost:8080/api/list permet d'enregistrer une nouvelle URL

Pour le web :

http://localhost:8080/ et http://localhost:8080/home renvoie vers la page d'acceuil home.vm
http://localhost:8080/page404 renvoie un code erreur 404 qui apparait lorsque l'utilisateur tente d'accéder à un url court non enregistré
