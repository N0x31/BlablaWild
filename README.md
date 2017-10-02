# BlablaWild

Partie 1 : Faire communiquer des Activities
1. Crée le projet avec les 3 Activities telles définies dans les étapes.
2. Implémente un bouton sur la MainActivity pour passer à SearchItineraryActivity.
3. Implémente le passage de données entre SearchItineraryActivity et ViewSearchItineraryResultsListActivity.
4. Affiche les paramètres de la recherche dans la barre de titre de ViewSearchItineraryResultsListActivity
5. Implémente les cas d'erreur quand l'utilisateur a oublié de remplir des champs obligatoires dans SearchItineraryActivity.

Critères de validation :
- Le projet contient les 3 Activities`
- Le fichier strings.xml contient tous les textes qui sont affichés dans la UI (sauf ceux saisis par l'utilisateur).
- Les paramètres de la recherche récupérés ViewSearchItineraryResultsListActivity reflètent bien ceux qui ont été saisis dans SearchItineraryActivity.
- Il n'y a pas de variable globale dans l'application.

Partie 2 : Implémenter une sélection de date via le DatePickerDialog
1. Intercepte le click sur l'EditText du champs "Date" dans le projet Bla Bla Wild pour afficher le DatePickerDialog
2. Implémente la récupération de la date sélectionnée pour l'afficher dans l'EditText.

Critéres de validation :
- Le clavier virtuel n'apparait pas quand l'utilisateur clique sur le champs Date
- Le DatePickerDialog apparait en proposant la date du jour par défaut
- Le click sur "Cancel" du DatePickerDialog ne change pas la valeur du champs Date
- Le click sur "OK" met à jour le champs Date avec la date sélectionnée

Partie 3 : Implémenter une classe Parcelable

1. Crée une classe SearchRequestModel dans le projet "Bla Bla Wild" telle qu'telle soit Parcelable.
2. Modifie SearchItineraryActivity pour qu'il n'y ait plus qu'un seul extra passé dans l'Intent destiné à ViewSearchItineraryResultsListActivity : une instance de SearchRequestModel.
3. Modifie ViewSearchItineraryResultsListActivity pour récupérer l'extra de type SearchRequestModel (et donc par nature de type Parcelable).
4. Affiche un Toast à l'ouverture de ViewSearchItineraryResultsListActivity avec la date sélectionnée par l'utilisateur.

Critéres de validation :
- Un seul extra est passé dans l'Intent entre SearchItineraryActivity et ViewSearchItineraryResultsListActivity
- Il n'y a aucune variable globale dans l'application
- Le titre de ViewSearchItineraryResultsListActivity affiche toujours "Départ » Destination" et un Toast avec la date apparait à l'ouverture de ViewSearchItineraryResultsListActivity.
- Le constructeur sans paramètre de SearchRequestModel est private.

Partie 4 : Implémenter une liste de trajets

1. Implémente ViewSearchItineraryResultsListActivity pour afficher une liste de trajets fictifs.
2. Remplis la liste avec des trajets fictifs en faisant le binding.

Critéres de validation
- La liste de trajets est affichée dans une ListView
- Les attributs de la classe TripResultAdapter ne sont accessibles que par les getters / setters
- La date de départ, le prénom du conducteur et le prix apparaissent dans chaque ligne de la liste
