angular.module('app').service('UserService', function($http){

	var url = 'user/';
	
	this.getAllUsers = function() { return $http.get(url + 'allUsers') };

});