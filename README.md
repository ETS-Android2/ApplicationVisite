# Application VisiteGuidée du Campus de l'IUT Montpellier-Sète

## <span style="color:#ccccff"><b><u> I. Comment démarrer l'application (sans IDE) ? </b></u>

-> Téléverser le fichier d'instalation .apk sur votre appareil androïd (ce fichier se trouve dans ./app/release/app-release.apk) <br />
-> Installer l'application <br />
-> Dans les paramètres de l'application, autoriser manuellement l'utilisation de la caméra <br />
-> Désactiver le mode sombre du smartphone (si il en possède un) </br>
-> Lancer l'application en étant connecté à internet 

## <span style="color:#ccccff"><b><u> II. Comment utiliser l'application (avec IDE) ?</b></u>

-> Telecharger Android Studio <br />
-> Installer les composants necessaires (jdk etc.) <br />
-> Ouvrir le projet<br />
-> Activer le mode développeur sur son smartphone androïd
-> Activer le déboggage USB
-> Une fois connecté par USB à l'ordinateur, il sera possible de run l'app sur l'appareil connecté.
-> L'application va s'installer sur le smartphone et vous pourrez vous référer au I.

## <span style="color:#ccccff"><b><u> III. Comment utiliser l'application ?</b></u>

-> Lancer l'application <br />
-> Scanner un qrCode pour obtenir + d'infos (Tous les QrCodes ont été générés et placé dans le dossier ./app/release/bat_a.png)


## <span style="color:#ccccff"><u><b> IV. Pour aller plus loin</u></u></b>
-> L'application utilise une base de données firebase. Si vous voulez avoir la main sur cette base de données, il faudra en créer une de votre coté. <br />
-> Une fois créée, il suffira d'importer le fichier .json comportant toutes les données qui sont sur la base actuelle. <br />
-> (ce fichier se trouve dans .app/release/applicationvisite-default-rtdb-export.json)
