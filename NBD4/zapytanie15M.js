var mapFunction = function() {
    if ( this.hasOwnProperty("credit") && this.nationality == "Poland" && this.sex == "Female") {

        for(var i = 0; i < this.credit.length; i++){
            emit(
                this.credit[i].currency,
                parseFloat(this.credit[i].balance)
            )
        }
    }

}

var reduceFunction = function(key, values){
    var result = {count:0, sum: 0}

    result.sum = Array.sum(values);
    result.count += values.length;

    return result;
};

var finalizeFunction = function(key, value){
    var result = {sum: 0, avg: 0};

    result.sum = value.sum;
    result.avg = value.sum/value.count;

    return result;
}


db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: "wynik_5",
        finalize: finalizeFunction
    }
)

printjson(db.wynik_5.find().toArray())