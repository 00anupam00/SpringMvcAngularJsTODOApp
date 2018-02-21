'use strict';

angular.module('todoApp').factory('LoginService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
            var factory = {
                validate: validateLogin
            };
            return factory;

            function validateLogin(login){
                console.log('Validating credentials...');
                var deferred = $q.defer();
                $http.post(urls.LOGIN_SERVICE_API, login)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Task : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);