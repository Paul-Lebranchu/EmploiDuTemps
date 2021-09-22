L2 informatique, groupe 3A, groupe de travail numéro 12

21914419 Charbelle BODJRENOU

21803239 Olivier COCQUEREZ

21403460 Paul LEBRANCHU

21802756 Raphaelle LEMAIRE


Placer l'archive scheduleio.jar dans le dossier contenant le dosiier build et le dossier EDT

Commande de compilation:

javac -d build/ -cp "scheduleio.jar" EDT/*.java

Commande d'exécution: 

java -cp build:scheduleio.jar EDT.GeneralCompile EDT/activites.txt EDT/contrainte.txt

[Cette instruction lancera le fichier GeneralCompile.class qui fabriquera un emploi du temps aléatoire (grâce à la class RandomSChedular) à partir des données
contenue dans les fichiers activities.txt et contrainte.txt (données lues par la class Reader)]

