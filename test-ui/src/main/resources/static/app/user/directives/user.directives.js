!function(e){"use strict";e.directive("validateEmail",function(){var e=/^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;return{require:"ngModel",restrict:"",link:function(r,i,n,t){t&&t.$validators.email&&(t.$validators.email=function(r){return t.$isEmpty(r)||e.test(r)})}}}),e.directive("numbersOnly",function(){return{require:"ngModel",link:function(e,r,i,n){function t(e){if(e){var r=e.replace(/[^0-9]/g,"");return r!==e&&(n.$setViewValue(r),n.$render()),r}}n.$parsers.push(t)}}})}(angular.module("user"));