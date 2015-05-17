'use strict'
var galleryService = angular.module('galleryServices',['ngResource']);

galleryService.factory('galleryService',function($resource){
    return $resource('/gallery/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

galleryService.factory('queryGalleryService',function($resource){
    return $resource('/getGallery/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})