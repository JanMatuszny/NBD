var map = function() {
	emit(this.sex, { heightSum: Number(this.height), weightSum: Number(this.weight), count: 1}) ;
};

var reduce = function(sex, values) {
	var a = values[0];
	for (var i=1; i < values.length; i++){
        var b = values[i];
        a.heightSum += b.heightSum;
        a.weightSum += b.weightSum;
        a.count += b.count;
	}
	return a;
}

var finalize = function (key, value){
    value.avgHeight = value.heightSum / value.count;
    value.avgWeight = value.weightSum / value.count;
    var result = {"avgWeight": value.avgWeight, "avgHeight": value.avgHeight}
    return result;
}
                      
db.people.mapReduce(map, reduce, {finalize:finalize, out:{inline:1}});