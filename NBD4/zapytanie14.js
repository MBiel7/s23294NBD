printjson(
    db.people.aggregate([
        {$project:{"nationality": "$nationality", "weight": "$weight", "height": "$height", "bmi": {$divide:[{"$toDouble": "$weight"}, {$pow: [{$divide: [{"$toDouble": "$height"}, 100]}, 2]}]}}},
        {$group:{_id: "$nationality", "avgBMI": {$avg: "$bmi"}, "maxBMI": {$max: "$bmi"}, "minBMI": {$min: "$bmi"}}}
    ]).toArray()
 )