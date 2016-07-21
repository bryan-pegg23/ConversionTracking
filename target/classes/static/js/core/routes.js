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

					}).

					when('/admin', {

						templateUrl : baseRoute + 'admin/adminPage.html',
						controller : 'AdminController',
						controllerAs : 'adminController',
						
						resolve: {
				              allLocations: function(LocationService){
					                  return LocationService.getAllLocals();
					          }
						}						
					}).
					
					when('/admin/:id', {

						templateUrl : baseRoute + 'admin/adminPage.html',
						controller : 'AdminController',
						controllerAs : 'adminController',
						
						resolve: {
				              allLocations: function(LocationService){
					                  return LocationService.getAllLocals();
					          }
						}						
					}).
					
					when('/location', {

						templateUrl : baseRoute + 'admin/addLocalTemp.html',
						controller : 'AddLocationController',
						controllerAs : 'addLocationController',
						
					}).
					
					when('/user/register', {

						templateUrl : baseRoute + 'register/registerUser.html',
						controller : 'registerUserController',
						controllerAs : 'registerUserController',
						
					}).
					
					otherwise('/home');
				} ]);