'use strict'
var accountService = angular.module('accountServices',['ngResource']);

accountService.factory('accountService',function($resource){
    return $resource('/user/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

accountService.factory('queryAccountService',function($resource){
    return $resource('/getAccount/?username=:username',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})