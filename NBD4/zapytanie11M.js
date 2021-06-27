var mapFunction = function(){
    if(this.sex){
        emit(this.sex,{count: 1, height: parseFloat(this.height), weight: parseFloat(this.weight)});
    }    
};

var reduceFunction = function(key, values){
    var result = {count:0, height: 0, weight: 0}

    values.forEach(values => {
        result.height += values.height;
        result.weight += values.weight;
        result.count += values.count;
    })
    return result;
};

var finalizeFunction = function(key, value){
    var result = {avgHeight: 0, avgWeight: 0};

    result.avgHeight = value.height/value.count;
    result.avgWeight = value.weight/value.count;

    return result;
}

db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: "wynik_1",
        finalize: finalizeFunction
    }
)

printjson(db.wynik_1.find().toArray())