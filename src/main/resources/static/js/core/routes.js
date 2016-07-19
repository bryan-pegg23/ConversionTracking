angular.module('app').config(
		[ '$routeProvider', 'baseRoute', 'homePage',
				function config($routeProvider, baseRoute, homePage) {

					$routeProvider.when('/home', {

						templateUrl : homePage,
						controller : 'HomeController',
						controllerAs : 'homeController'

					}).
					
					when('/user', {

						templateUrl : baseRoute + 'user/userPage.html',
						controller : 'UserController',
						controllerAs : 'userController',
						resolve : {
							allUsers : function(UserDetailService) {
								return UserDetailService.userLogin
							}
						}
					}).

					when('/admin', {

						templateUrl : baseRoute + 'admin/adminPage.html',
						controller : 'UserController',
						controllerAs : 'userController',
						resolve : {
							allUsers : function(UserDetailService) {
								return UserDetailService.userAdmin
							}
						}
					}).
					
					otherwise('/home');
				} ]);