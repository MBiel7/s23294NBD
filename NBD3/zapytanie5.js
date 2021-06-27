printjson(
    db.people.find(
        { $expr: { $lte: [ { $toDate : "$birth_date" }, new Date('2100-12-31') ] },$expr: { $gte: [ { $toDate : "$birth_date" }, new Date('2001-01-01') ] } },
        { "_id": 0, "first_name": 1, "last_name": 1, "location.city": 1
        }).toArray()
    )