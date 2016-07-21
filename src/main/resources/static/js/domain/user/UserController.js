angular.module('app').controller('UserController', ['$location', 'UserService',function( $location,  UserService) {

	var ctrl = this
	
	ctrl.message = "Bryan Pegg"
		
	if(loggedIn != 'user'){
		$location.path('/home')
	}
	
}]);