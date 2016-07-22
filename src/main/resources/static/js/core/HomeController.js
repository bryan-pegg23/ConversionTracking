
angular.module('app').controller('HomeController', [ "$scope", "UserService", "$location", function HomeController($scope, UserService, $location)
{
	var ctrl = this;
	
	ctrl.login = function() {
		login = $scope.user
		console.dir(login)
		UserService.userLogin(login)
			.then(function (result){
				console.dir(result.data)
				var data = result.data
				if(data.admin === "yes"){
//					loggedIn = "admin"
					$location.path("/admin")
				}else if(data.admin === "no"){
//					loggedIn = "user"
					$location.path("/user")
				} else{
					loggedIn = null
					alert("Please register the user before trying to log in");
				}
				
			})
	}
	
	ctrl.register = function() {
			$location.path('/user/register')
	}
	
	

}]);