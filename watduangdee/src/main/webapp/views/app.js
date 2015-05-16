'use strict';

// Declare app level module which depends on views, and components
var labApp = angular.module('labApp', [
    'ngRoute',
    'productMainController',
    'languageControllers',
    'languageServices',
    'pascalprecht.translate',
    'shoppingCartControllers',
    'flow',
    'securityControllers'
])
labApp.config(['$routeProvider',
  function($routeProvider) {
  $routeProvider.
      when('/addProduct',{
          templateUrl: 'template/editProduct.html',
          controller: 'addProductController'
      }).
      when('/editProduct/:id',{
          templateUrl: 'template/editProduct.html',
          controller: 'editProductController'
      }).
      when('/listProduct',{
          templateUrl: 'template/productList.html',
          controller: 'listProductController'
      }).
      when('/shoppingCart/:id',{
          templateUrl: 'template/shoppingCart.html',
          controller: 'showShoppingCartController'
      }).
       otherwise({redirectTo: '/listProduct'});
}]);

labApp.config(function($translateProvider){
    $translateProvider.useUrlLoader('/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');
})

labApp.config(['flowFactoryProvider', function (flowFactoryProvider) {
    flowFactoryProvider.defaults = {
        target: '',
        permanentErrors: [ 500, 501],
        maxChunkRetries: 1,
        chunkRetryInterval: 5000,
        simultaneousUploads: 4,
        singleFile: false
    };
    flowFactoryProvider.on('catchAll', function (event) {
        console.log('catchAll', arguments);
    });
    // Can be used with different implementations of Flow.js
    // flowFactoryProvider.factory = fustyFlowFactory;
}]);

labApp.config(['$locationProvider','$httpProvider',function($locationProvider,$httpProvider){
$httpProvider.interceptors.push(function($q,$rootScope,$location){
    return {
        'responseError' : function(rejection){
            var status = rejection.state;
            var config = rejection.config;
            var method = config.method;
            var url    = config.url;

            if(status ==401){
                $location.path("/listProduct");
            }else{
                $rootScope.error = method + " on " + url + " failed with status "+status;

            }
            return $q.reject(rejection);
        }
    }
});
    var exampleAppConfig = {
        userAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'request' : function(config){
                if(angular.isDefined($rootScope.authToken)){
                    var authToken  = $rootScope.authToken;
                    if(exampleAppConfig.userAuthTokenHeader){
                        config.headers['X-Auth-Token'] = authToken;
                    }else{
                        config.url =config.url +"?token="+authToken;
                    }
                }
                return config || $q.when(config);
            }
        }
    })
}]).run(function($rootScope,$location,$cookieStore,UserService) {
    $rootScope.$on('$viewContentLoaded', function () {
        delete $rootScope.error;
    });


    var originalPath = $location.path();
    $location.path("/listProduct");
    var authToken = $cookieStore.get('authToken');
    if (authToken != undefined) {
        $rootScope.authToken = authToken;
        UserService.get(function (user) {
            $rootScope.user = user;
            $location.path(originalPath);
        })
    }
    $rootScope.initialized = true;

    $rootScope.hasRole = function(role){
        if($rootScope.user == undefined){
            return false;
        }
        if($rootScope.user.roles[role] == undefined){
            return false;
        }
        return $rootScope.user.roles[role];
    }
});
