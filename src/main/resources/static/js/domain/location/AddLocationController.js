angular.module('app').controller('AddLocationController', ['$http', '$location', 'LocationService', '$scope' , function($http, $location, LocationService, $scope) {
	var url = 'user/';
	var ctrl = this;

	ctrl.addLocal = function() {
		var local = $scope.local
		console.dir(local)
			LocationService.addLocal(local)
			.then(function (result){
				console.dir(result.data)
			})
	}
}])