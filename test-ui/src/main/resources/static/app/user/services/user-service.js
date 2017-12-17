(function (module) {

    'use strict';

    module.service('UserService', ['$http', function ($http) {

        function handleError(response) {

        }

        function handleSuccess(response) {
            return (response.data);
        }

        var saveUser = function (user) {

            var request = "";

            if (user.id) {

                request = $http({
                    method: "PUT",
                    url: ENDPOINT + API_USER + "/" + user.id,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    data: JSON.stringify(user)
                });

            } else {

                request = $http({
                    method: "POST",
                    url: ENDPOINT + API_USER,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    data: JSON.stringify(user)
                });

            }

            return (request.then(handleSuccess, handleError));
        };

        var listUser = function (id) {

            var request = $http({
                method: "GET",
                url: ENDPOINT + API_USER + "/" + id,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                }
            });

            return (request.then(handleSuccess, handleError));

        };

        var loadUsers = function (user) {

            var request = $http({
                method: "GET",
                url: ENDPOINT + API_USER,
                headers: {
                    'Accept': 'application/json'
                }
            });

            return (request.then(handleSuccess, handleError));

        };

        var removeUser = function (id) {

            var request = $http({
                method: "DELETE",
                url: ENDPOINT + API_USER + "/" + id,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                }
            });

            return (request.then(handleSuccess, handleError));

        };

        return {
            loadUsers: loadUsers,
            listUser: listUser,
            saveUser: saveUser,
            removeUser: removeUser
        };

    }])

})(angular.module('user'));


