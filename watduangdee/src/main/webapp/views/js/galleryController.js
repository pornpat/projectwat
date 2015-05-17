'use strict';

var galleryMainController = angular.module('galleryMainController', ['galleryServices']);

galleryMainController.controller('addGalleryController', ['$scope', '$http', '$location', '$rootScope','galleryService',
    function ($scope, $http, $location, $rootScope,galleryService) {
        $scope.gallery = {};
        $scope.addPerson = true;
        $scope.editPerson = false;

        $scope.addGallery = function (flowFiles) {

            galleryService.save($scope.gallery,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var galleryid = data.id;
                // set location
                flowFiles.opts.target = '/galleryImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={galleryid:galleryid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("gallery");
                $scope.$apply();
            });
        };
    }]);

galleryMainController.controller('listGalleryController', ['$scope', '$http', '$rootScope','galleryService','$route','queryGalleryService',
    function ($scope, $http, $rootScope,galleryService,$route,queryGalleryService) {
        //$http.get("/product/").success(function (data) {
        var data = galleryService.query(function(){
            // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
            $scope.galleries = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

    }]);