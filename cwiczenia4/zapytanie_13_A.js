db.people.aggregate([
	{ $group: { _id: "$job", uniqueCount: { $sum: 1}}},
	{ $sort: { _id: 1}},
])

