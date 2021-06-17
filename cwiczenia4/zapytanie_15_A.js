db.people.aggregate([	
	{ $match: {sex: "Female", nationality: "Poland"} },
	{ $unwind: "$credit" },
	{ $group: { _id: "$credit.currency", balanceSum: {$sum: "$credit.balance"}, average: {$avg: "$credit.balance"}}},
	{ $sort: {_id: 1}}
]);