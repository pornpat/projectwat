'use strict';

var qandaMainController = angular.module('qandaMainController', ['qandaServices']);

qandaMainController.controller('addQandaController', ['$scope', '$http', '$location', '$rootScope','qandaService',
    function ($scope, $http, $location, $rootScope,qandaService) {
        $scope.qanda = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addQanda = function () {

            qandaService.save($scope.qanda,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var qanda = data.id;
                // set location

                $rootScope.addSuccess = true;
                $location.path("listProduct");
                $scope.$apply();
            });
        };

    }]);

qandaMainController.controller('listQandaController', ['$scope', '$http', '$rootScope','qandaService','$route',
    function ($scope, $http, $rootScope,qandaService,$route) {
        //$http.get("/product/").success(function (data) {
        var data = qandaService.query(function(){
            // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
            $scope.qandas = data;
        });

        $scope.qanda = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addQanda = function () {

            qandaService.save($scope.qanda,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var qanda = data.id;
                // set location

                $rootScope.addSuccess = true
                $scope.$apply();
                $route.reload();
            });
        };

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteQanda = function (id) {
            var answer = confirm("Do you want to delete the question?");
            if (answer) {
                qandaService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }

        $scope.searchQanda = function(name){
            queryQandaService.query({name:name},function(data) {
                $scope.qandas = data;
            });
        }

    }]);

qandaMainController.controller('editQandaController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','qandaService',
    function ($scope, $http, $routeParams, $location, $rootScope,qandaService) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;

        $http.get("/qanda/" + id).success(function (data) {
            $scope.qanda = data;
        });

        $scope.editQanda = function () {
            qandaService.update({id:$scope.qanda.id},$scope.qanda,function(){
                $rootScope.editSuccess = true;
                $location.path("qanda");
            });
        }
    }]);