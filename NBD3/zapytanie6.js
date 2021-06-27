
db.people.insert(
    {

        "sex" : "Male",
        "first_name" : "Maciej",
        "last_name" : "Bielicki",
        "job" : "Software developer",
        "email" : "s23294@pjwstk.edu.pl",
        "location" : {
            "city" : "Warszawa",
            "address" : {
                "streetname" : "Wiejska",
                "streetnumber" : "4"
            }
        },
        "description" : "lorem ipsum",
        "height" : "186",
        "weight" : "90",
        "birth_date" : "1996-03-13",
        "nationality" : "Poland",
        "credit" : [
            {
                "type" : "switch",
                "number" : "6759888939100098699",
                "currency" : "PLN",
                "balance" : "7.06"
            }
        ]
    }
)


printjson(db.people.find({"last_name":"Bielicki","first_name" : "Maciej"}).toArray())