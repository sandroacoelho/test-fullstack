(function (module) {

	'use strict';

    module.config(['$urlRouterProvider', '$stateProvider',
		function ($urlRouterProvider, $stateProvider) {

			$urlRouterProvider.otherwise('/user');

			$stateProvider.state('user', {
				url: '/user',
				templateUrl : 'app/user/views/list.html',
				controller : 'UserController'
			}).state('user/add', {
				url: '/user/add',
				templateUrl : 'app/user/views/user.html',
				controller : 'UserController'
			}).state('user/edit', {
                url: '/user/:userId',
				templateUrl : 'app/user/views/user.html',
                controller : 'UserController'
            });
}]);

    module.run(['$rootScope', '$state',
		function ($rootScope, $state) {}]);

})(angular.module('test', ['ui.router', 'user']));

