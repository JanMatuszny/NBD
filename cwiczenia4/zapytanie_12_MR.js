var map = function () {
  	for(var i = 0; i < this.credit.length; i++) {
  	  emit(this.credit[i].currency, { balanceSum: Number(this.credit[i].balance)});
  	}
}

var reduce = function(key, values) {
  	var a = values[0];
  	for(var i = 1; i < values.length; i++) {
  	  	var b = values[i];
  	 	a.balanceSum += b.balanceSum;
  	}
 	return a; 
}

db.people.mapReduce(map, reduce, {out:{inline:1}});