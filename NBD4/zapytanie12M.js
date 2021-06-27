var mapFunction = function() {
    if ( this.hasOwnProperty("credit")) {

        for(var i = 0; i < this.credit.length; i++){
            emit(
                this.credit[i].currency,
                parseFloat(this.credit[i].balance)
            )
        }
    }

}

var reduceFunction = function(key, value){
    return Array.sum(value);
};

db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: "wynik_2"
    }
)

printjson(db.wynik_2.find().toArray())