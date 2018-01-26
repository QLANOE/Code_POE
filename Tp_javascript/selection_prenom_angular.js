
angular.module('angularApp', [])
.controller('NameController', function() {

	this.modif=true;
  this.listePersonnes = [];
  this.isChecked=[];
  this.selection=[];

  this.ajouterPersonne= function(){

    personneTrouvee=false;
    if(this.prenom=="" || this.nom=="" || this.age==""){
        console.log("Un des champs de saisie est vide.");
      }
    else{
        var personne = { prenom : this.prenom, nom : this.nom, age : this.age};
        for(var i = 0; i < this.listePersonnes.length; i++){
          if(this.listePersonnes[i].prenom == this.prenom && this.listePersonnes[i].nom == this.nom && this.listePersonnes[i].age == this.age){
            personneTrouvee=true;
            break;
          }
        }
        if(personneTrouvee==false){
          this.listePersonnes.push(personne);
          this.isChecked.push(false);
          this.selection=[];
        }
        else{
          alert("La personne existe déjà! Veuillez recommencer.");
        }
      }
  }

this.detruirePersonne=function(i){
      this.listePersonnes.splice(i, 1);
      this.isChecked.splice(i, 1); 
      this.selection=[];  
}

this.selectionnerPersonne=function(i){

	this.selection=[];
	this.isChecked[i]=!this.isChecked[i];
	for(i=0;i<this.listePersonnes.length;i++){

		if(this.isChecked[i]){
			this.selection.push(this.listePersonnes[i]);
		}
	}

	}

		


});