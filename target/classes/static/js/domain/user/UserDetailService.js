angular.module('app').service('UserDetailService', ['$http', function($http) {
	
	var url = 'user/';
	
	this.userLogin = function(user) {return $http.post(url + "login", user)}

}])