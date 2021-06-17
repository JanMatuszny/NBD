//wersja z pipeline
//konwersja pól na wartości liczbowe
db.people.find().forEach(function(person) {
	person.height = parseInt(person.height);
	person.weight = parseInt(person.weight);
	db.people.save(person);
});

//zapytanie grupujące
db.people.aggregate([
	{ $group: { _id: "$sex", avgHeight: {$avg: "$height"}, avgWeight: {$avg: "$weight"}}}
])