angular.module('app').controller('AdminController', ['$http', '$location', 'allLocations', 'LocationService','$scope', function($http, $location, allLocations, LocationService, $scope) {
	var url = 'user/';
	var ctrl = this;
	this.currentType = 'all';
	this.availableTypes = ['all', 'day', 'week', 'month', 'year'];
	$scope.locations = allLocations.data
	
	this.userAdmin = function(user) {
		return $http.post(url + "login", user)
	}
	
	ctrl.addLocal = function() {
		$location.path('/location')
	}
	
	this.typeSelected = function(type) {
		this.currentType = type;
		if (type === 'all') {
			$scope.locations = allLocations.data;
			console.dir($scope.locations)
		}else {
			LocationService.getLocationsByDays(type)
			.then(function (result) { 
				$scope.locations = result.data;
				console.dir($scope.locations)
			})
		}
	}	
	
	ctrl.goLocation = function(){
		
	}
	
	if (loggedIn != "admin") {
		loggedIn = null
		$location.path('/home')
	}

}]);