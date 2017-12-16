(function (module) {

    'use strict';

    module.controller('UserController', ['$scope', 'UserService', function ($scope, userService) {

         userService.listUsers().then(function(users) {
             $scope.users = users;
         });

         $scope.removeUser = function(id) {

             userService.removeUser(id).then(function() {
                 userService.listUsers().then(function(users) {
                     $scope.users = users;
                 });
             });

         };

         $scope.saveUser = function(form) {

             $scope.submitted = true;

             if (form.$invalid) {
                 return;
             }

             var user = {
                 name: form.name.$modelValue,
                 email: form.email.$modelValue,
                 phone: form.phone.$modelValue,
                 sex: form.sex.$modelValue
             };

             userService.saveUser(user).then(function() {
             });
         };


    }]);


})(angular.module('user'));