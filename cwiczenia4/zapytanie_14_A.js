db.people.aggregate([
	{$group: {_id: "$_id", nationality: { $first: "$nationality"}, weight: { $first: "$weight"}, height: { $first: "$height"}, count: {$sum: 1}}},
	{ $project: {
	  nationality: "$nationality",
	  BMI: {$divide: ["$weight", { $multiply: [{ $divide: ["$height", 100]}, { $divide: ["$height", 100]}]}]},
	}},
	{ $group: {_id: "$nationality", minBMI: {$min: "$BMI"}, avgBMI: {$avg: "$BMI"}, maxBMI: {$max: "$BMI"}}},
	{ $sort: { _id: 1}},
])
