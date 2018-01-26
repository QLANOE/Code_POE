
var listePersonnes=[];

function ajouterPersonne(){

			var prenom=document.getElementById('prenomInput').value;
			var nom=document.getElementById('nomInput').value;
			var age=document.getElementById('ageInput').value;
			personneTrouvee=false;

			if(prenom=="" || nom=="" || age==""){
				alert("Un des champs de saisie est vide.")
			}
			else{

				var personne={Prenom:prenom, Nom:nom,Age:age};
				for(i=0;i<listePersonnes.length;i++){
					if(listePersonnes[i].Prenom==prenom && listePersonnes[i].Nom==nom && listePersonnes[i].Age==age){
						personneTrouvee=true;
						break;
					}
				}
				if(personneTrouvee==false){
					listePersonnes.push(personne);
					listePersonnes.sort(triageAlphabetiquePrenom);
					afficherTableau();
					afficherSelection();
				}
				else{
					alert("La personne existe déjà! Veuillez recommencer.")
				}
			}
		}

function detruirePersonne(i){
			listePersonnes.splice(i, 1);
			afficherTableau();
			afficherSelection();		
}

function afficherTableau(){
			var select=document.getElementById("tableBody");
			select.innerHTML="";
			for (var i = 0; i<listePersonnes.length; i++) {
			html = '<tr>';

				html += '<td><input id="checkBox'+i+'" type="checkbox" checked onchange="selectionnerPersonne('+i+')"></td>';
			  	html += '<td>' + listePersonnes[i].Prenom+ '</td>';
			  	html += '<td>' + listePersonnes[i].Nom+ '</td>';
			  	html += '<td>' + listePersonnes[i].Age+ '</td>';
			  	html += '<td><a class="deleteBtn'+i+'" onclick="detruirePersonne('+i+')">&#10006;</a></td></tr>';

			select.innerHTML+=html;
			}	
		}

function afficherSelection(){

			select=document.getElementById("selectionList");
			select.innerHTML="";

			for (var i = 0; i<listePersonnes.length; i++) {
			if(document.getElementById('checkBox'+i).checked==true){
				html = '<ul>';
			  	html+='<li>'+listePersonnes[i].Prenom+ ' '+listePersonnes[i].Nom+ ' '+listePersonnes[i].Age+' ans'+ '</li></ul>';
				select.innerHTML+=html;
				}	
			}	
		}

function selectionnerPersonne(i){
	afficherSelection();
}

function modifierTableau(){

			var select=document.getElementById("tableBody");
			select.innerHTML="";
			for (var i = 0; i<listePersonnes.length; i++) {
			html = '<tr>';

				html += '<td><input id="checkBox'+i+'" type="checkbox" checked onchange="selectionnerPersonne('+i+')"></td>';
			  	html += '<td><input type="text" id="prenomInput'+i+'" value='+listePersonnes[i].Prenom+'></td>';
			  	html += '<td><input type="text" id="nomInput'+i+'" value='+listePersonnes[i].Nom+'></td>';
			  	html += '<td><input type="text" id="ageInput'+i+'" value='+listePersonnes[i].Age+'></td>';
			  	html += '<td><a class="deleteBtn'+i+'" onclick="detruirePersonne('+i+')">&#10006;</a></td></tr>';

			select.innerHTML+=html;
			}

			select=document.getElementById("interface");
			select.innerHTML=''
			html = '<input type="text" id="prenomInput" placeholder="prenom">';
			html += '<input type="text" id="nomInput" placeholder="nom">';
			html += '<input type="number" id="ageInput" placeholder="age">';
			html += '<button type="button" onclick="ajouterPersonne()">Ajouter personne</button>';
			html += '<button type="button" onclick="sauvegarderChangement()">Sauvegarder le changement</button>';
			select.innerHTML=html;
}

function sauvegarderChangement(){

			for (var i = 0; i<listePersonnes.length; i++) {

			listePersonnes[i].Prenom=document.getElementById('prenomInput'+i).value;
			listePersonnes[i].Nom=document.getElementById('nomInput'+i).value;
			listePersonnes[i].Age=document.getElementById('ageInput'+i).value;
			}

			afficherTableau();
			afficherSelection();

			select=document.getElementById("interface");
			select.innerHTML=''
			html = '<input type="text" id="prenomInput" placeholder="prenom">';
			html += '<input type="text" id="nomInput" placeholder="nom">';
			html += '<input type="number" id="ageInput" placeholder="age">';
			html += '<button type="button" onclick="ajouterPersonne()">Ajouter personne</button>';
			html += '<button type="button" onclick="modifierTableau()">Modifier la saisie</button>';
			select.innerHTML=html;
}

function triageAlphabetiquePrenom(){

	listePersonnes.sort(function(personne1,personne2){return personne1.Prenom.localeCompare(personne2.Prenom)});
	afficherTableau();
	afficherSelection();

}

function triageAlphabetiqueNom(){

	listePersonnes.sort(function(personne1,personne2){return personne1.Nom.localeCompare(personne2.Nom)});
	afficherTableau();
	afficherSelection();
}

function triageAge(){

	listePersonnes.sort(function(personne1,personne2){return personne1.Age-personne2.Age});
	afficherTableau();
	afficherSelection();
}

function triage(parametre){

	listePersonnes.sort(function(personne1,personne2){return personne1["parametre"]>personne2.["parametre"]?+1:-1});
	afficherTableau();
	afficherSelection();
}


