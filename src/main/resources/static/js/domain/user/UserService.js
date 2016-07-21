angular.module('app').service('UserService', [ '$http', function($http) {
	var url = 'user/';

	this.userLogin = function(user) {
		console.dir(user);
		return $http.post(url + "login", user)
	}
	
	this.getLocation = function(id){
		return $http.get(url + id)
	}
	
} ])