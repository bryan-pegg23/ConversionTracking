angular.module('app').controller('AdminController', ['$http', '$location', 'allLocations', function($http, $location, allLocations) {
	var url = 'user/';
	var ctrl = this;

	this.userAdmin = function(user) {
		return $http.post(url + "login", user)
	}
	
	ctrl.addLocal = function() {
		$location.path('/location')
	}
	
	ctrl.locations = allLocations.data
	
//	if (loggedIn != "fuck") {
//		loggedIn = null
//		$location.path('/home')
//	}

}]);