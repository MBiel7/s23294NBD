var mapFunction = function(){
    if(this.nationality){
        emit(
            this.nationality,
            {count: 1, bmi: parseFloat(this.weight)/(parseFloat(this.height)/100 * parseFloat(this.height)/100)}
        );
    }    
};

var reduceFunction = function(key, values){
    var result = {count:0, bmi: 0, maxBMI: 0, minBMI: 100}

    values.forEach(values => {
        result.bmi += values.bmi;
        result.count += values.count;
        if (result.maxBMI < values.bmi) result.maxBMI = values.bmi;
        if (result.minBMI > values.bmi) result.minBMI = values.bmi;
    })

    return result;
};

var finalizeFunction = function(key, value){
    var result = {avgBMI: 0, maxBMI: 0, minBMI: 0};

    result.avgBMI = value.bmi/value.count;
    result.maxBMI = value.maxBMI;
    result.minBMI = value.minBMI;

    return result;
}

db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: "wynik_4",
        finalize: finalizeFunction
    }
)

printjson(db.wynik_4.find().toArray())