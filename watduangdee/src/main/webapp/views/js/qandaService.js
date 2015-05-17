'use strict'
var qandaService = angular.module('qandaServices',['ngResource']);

qandaService.factory('qandaService',function($resource){
    return $resource('/qanda/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

