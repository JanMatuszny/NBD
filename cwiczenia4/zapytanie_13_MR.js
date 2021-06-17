var map = function() {
  emit(this.job, 1);
};

var reduce = function(key, values) {
  var counter = 0;
  
  for(var i = 0; i < values.length; i++) {
    counter += values[i];
  };
  return counter;
};

var finalize = function(key, value) {
	return {counter: value}; 
}

db.people.mapReduce(map, reduce, {out:{inline:1}});