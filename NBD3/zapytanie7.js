db.people.deleteMany({ $expr: { $gt: [ { $toDouble: "$height" }, 190 ] } })

printjson(db.people.find({ $expr: { $gt: [ { $toDouble: "$height" }, 190 ] } }).toArray())