var map = function() {
  	var heightInMeters = Number(this.height)/100;
	var bmi = Number(this.weight)/(heightInMeters*heightInMeters);
	
 	emit(this.nationality, {minBMI: bmi, maxBMI: bmi, sumBMI: bmi, counter: 1}); 
}

var reduce = function(key, values) {
	var a = values[0];
	
	for (var i = 1; i < values.length; i++) {
	  	var b = values[i];
	  	
	  	if(a.minBMI > b.minBMI) {
	  	 	a.minBMI = b.minBMI; 
	  	}
	  	
	  	if(a.maxBMI < b.maxBMI) {
	  	 	a.maxBMI = b.maxBMI; 
	  	}
	  	a.sumBMI += b.sumBMI;
	 	a.counter += b.counter; 
	}
	return a;
}

var finalize = function (key, value){
    var avgBMI = value.sumBMI/value.counter;
    var result = {"minBMI": value.minBMI, "avgBMI": avgBMI, "maxBMI": value.maxBMI}
    return result;
}

db.people.mapReduce(map, reduce, {finalize:finalize, out:{inline:1}});