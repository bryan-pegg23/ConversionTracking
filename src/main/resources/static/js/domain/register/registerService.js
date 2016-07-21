angular.module('app').service('registerService', [ '$http', function($http) {
	var url = 'user/register';

	this.registerUser = function(local) {
		console.dir(local);
		return $http.post(url, local)
	}
	
}])