//wersja z pipeline
//konwersja pól na wartości liczbowe
db.people.find().forEach(function(person) {
	if(person.credit != null) {
	  for(var i = 0; i < person.credit.length; i++) {
	  	person.credit[i].balance = parseInt(person.credit[i].balance); 	 
	  }
	  db.people.save(person);
	} 
});

//zapytanie agregujące
db.people.aggregate([ 
	{ $unwind: "$credit" },
	{ $group: { _id: "$credit.currency", balanceSum: {$sum: "$credit.balance"}}},
	{ $sort: {_id: 1}}
]);