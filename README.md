# Emploi du temps
Projet de deuxième année de licence d'informatique: Création d'une application de gestion d'emploi temps en console avec Java  
Projet de groupe

## Membres du groupe

* 21914419 Charbelle BODJRENOU
* 21803239 Olivier COCQUEREZ
* 21403460 Paul LEBRANCHU
* 21802756 Raphaelle LEMAIRE

## Comment faire fonctionner le projet?

Placer l'archive scheduleio.jar dans le dossier contenant le dosiier build et le dossier EDT (*cette archive nous avait été fournis en cours mais n'est plus disponible*)

Commande de compilation:

javac -d build/ -cp "scheduleio.jar" EDT/*.java

Commande d'exécution: 

java -cp build:scheduleio.jar EDT.GeneralCompile EDT/activites.txt EDT/contrainte.txt

