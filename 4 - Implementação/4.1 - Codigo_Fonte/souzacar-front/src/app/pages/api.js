(function ()
{
    'use strict';

    angular
        .module('SouzaCar')
        .factory('api', apiService);

    /** @ngInject */
    function apiService($http)
    {

        var api = {};

        // Base Url
        api.baseUrl = 'http://localhost:8080';

        api.financial = {
            account: {
                get: function(){ 
                    return $http({
                        method:"GET", 
                        url: api.baseUrl + '/api/accounts'
                    }); 
                },
                post: function( account ){
                    return $http({
                        method:"POST", 
                        url: api.baseUrl + '/api/accounts',
                        data: account
                    });   
                },
                put: function( account ){
                    return $http({
                        method:"PUT", 
                        url: api.baseUrl + '/api/accounts/' + account.id,
                        data: account
                    });   
                }
            } 
        };

        return api;
    }
    
})();