
angular.module('app').controller('HomeController', [ "$scope", "UserDetailService", "$location", function HomeController($scope, UserDetailService, $location)
{
	var ctrl = this;
	
	ctrl.login = function() {
		login = $scope.user
		console.dir(login)
		UserDetailService.userLogin(login)
			.then(function (result){
				console.dir(result.data)
				var data = result.data
				if(data.admin === "yes"){
					$location.path("/admin")
				}else if(data.admin === "no"){
					$location.path("/user")
				} else{
					alert("Please register new user first")
				}
				
			})
	}

}]);