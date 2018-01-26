 //console.log("bijour");

var url= 'https://data.rennesmetropole.fr/api/records/1.0/search/?dataset=alertes-trafic-en-temps-reel-sur-les-lignes-du-reseau-star&facet=niveau&facet=debutvalidite&facet=finvalidite&facet=idligne&facet=nomcourtligne';


//var alertesStar={debutValidite:DebutValidite, description:Description,finValidite:FinValidite,niveau:Niveau};

// appelle de l'url 
 fetch(url)
 // on dit au navigateur que le résultat en json
.then(function(response){
	return response.json();
})
// je fais quelque chose avec les datas renvoyees
.then(function(data){
	console.log(data);
	console.log(data.records[0]);
	console.log(data.records[0].fields);
	console.log(data.records[0].fields.debutvalidite);

	var select=document.getElementById("machin");
	select.innerHTML="";
	for (var i = 0; i<data.records.length; i++) {

	html = '<tr>';

		html += '<td style="color:#6495ED";>' + new Date(data.records[i].fields.debutvalidite).toLocaleDateString()+ '</td>';
		html += '<td style="color:red";>' + data.records[i].fields.description+ '</td>';
		html += '<td style="color:#6495ED">' + new Date(data.records[i].fields.finvalidite).toLocaleDateString()+ '</td>';
		html += '<td style="color:red";>' + data.records[i].fields.niveau+ '</td></tr>';

		select.innerHTML+=html;
		}	
	});

