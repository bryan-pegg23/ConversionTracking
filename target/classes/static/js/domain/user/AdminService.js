angular.module('app').service('UserService', function($http){

	var url = 'user/';
	
	this.userAdmin = function(user) {return $http.post(url + "login", user)}
	
});