var map = function() {
	for(var i = 0; i < this.credit.length; i++) {
		if(this.sex == "Female" && this.nationality == "Poland") {
		  emit(this.credit[i].currency, { balanceSum: Number(this.credit[i].balance), counter: 1}); 
  		};
	};
};

var reduce = function(key, values) {
	var a = values[0];
	
	for (var i = 1; i < values.length; i++) {
	  	var b = values[i];
	  	a.balanceSum += b.balanceSum;
	  	a.counter += b.counter;
	}
	return a;
}

var finalize = function (key, value){
    var result = {"avg": value.balanceSum/value.counter, "sum": value.balanceSum}
    return result;
}

db.people.mapReduce(map, reduce, {finalize:finalize, out:{inline:1}});