var mapFunction = function() {
    emit(this.job, 1)
}

var reduceFunction = function(key, value){
    return;
};

db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: "wynik_3"
    }
)

printjson(db.wynik_3.find().toArray())