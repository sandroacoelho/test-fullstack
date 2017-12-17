(function (module) {

    'use strict';

    module.controller('UserController', ['$scope', '$state', 'UserService', function ($scope, $state,  userService) {

         userService.loadUsers().then(function(users) {
            $scope.users = users;
        });

         $scope.$state = $state;

         $scope.removeUser = function(id) {

             userService.removeUser(id).then(function() {
                 userService.loadUsers().then(function(users) {
                     $scope.users = users;
                 });
             });

         };

         $scope.saveUser = function(form) {

             $scope.submitted = true;

             if (form.$invalid) {
                 return;
             }

             console.log(form);

             var user = {
                 id: form.id ? form.id.$modelValue : null,
                 name: form.name.$modelValue,
                 email: form.email.$modelValue,
                 phone: form.phone.$modelValue,
                 sex: form.sex.$modelValue
             };

             userService.saveUser(user).then(function() {
                 $state.go('user');
             });

         };

         $scope.loadUser = function() {
             if ($state.params.userId) {
                 userService.listUser($state.params.userId).then(function (user) {
                     $scope.user = user;
                 });
             }
         };

         $scope.loadUser();
    }]);


})(angular.module('user'));