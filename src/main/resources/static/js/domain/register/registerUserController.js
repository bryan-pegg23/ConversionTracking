angular.module('app').controller('registerUserController', ['$http', '$location', 'registerService','$scope', function($http, $location, registerService, $scope) {
	var ctrl = this;

	ctrl.register = function() {
		var local = $scope.local
		console.dir(local)
			registerService.registerUser(local)
			.then(function (result){
				console.dir(result.data)
			})
	}
	
	ctrl.goHome = function() {
		$location.path('/home')
	}

}]);