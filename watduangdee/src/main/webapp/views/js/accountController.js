'use strict';

var accountMainController = angular.module('accountMainController', ['accountServices']);

accountMainController.controller('addAccountController', ['$scope', '$http', '$location', '$rootScope','accountService',
    function ($scope, $http, $location, $rootScope,accountService) {
        $scope.user = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addAccount = function () {

            accountService.save($scope.user,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var accountid = data.id;
                // set location

                $rootScope.addSuccess = true;
                $location.path("listProduct");
                $scope.$apply();
            });
        };


    }]);

accountMainController.controller('editAccountController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','accountService',
    function ($scope, $http, $routeParams, $location, $rootScope,accountService) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;
        $http.get("/account/" + id).success(function (data) {
            $scope.account = data;
        });

        $scope.editAccount = function () {
            //$http.put("/product", $scope.product).then(function () {
            accountService.update({id:$scope.account.id},$scope.account,function(){
                $rootScope.editSuccess = true;
                $location.path("listProduct");
            });
        }
    }]);