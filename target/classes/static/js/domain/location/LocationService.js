angular.module('app').service('LocationService', [ '$http', function($http) {
	var url = 'Location/';

	this.addLocal = function(local) {
		console.dir(local);
		return $http.post(url, local)
	}
	
	this.getAllLocals = function(){
		return $http.get(url + 'getAll')
	}
	
} ])