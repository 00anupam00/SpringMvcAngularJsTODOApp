'use strict';

angular.module('todoApp').controller('LoginController',
    ['LoginService', '$scope','$location','$timeout', function( LoginService, $scope, $location, $timeout) {

        var self= this;
        self.login= {};

        self.submit=  submit

        function submit() {
            console.log('Submitting Login credentials');
            if (self.login.uname != undefined || self.login.password != null) {
                console.log('Loggin in...', self.login);
                LoginService.validate(self.login)
                    .then(
                        function (response) {

                            console.log('Logged in successfully');
                            self.successMessage = 'Welcome '+ self.login.uname+', You are logged in successfully';
                            self.errorMessage='';
                            self.done = true;
                            self.login={};

                            $timeout(function() {
                                $location.path('validate');
                            }, 2000);

                        },
                        function (errResponse) {
                            console.error('Error while loggin in');
                            self.errorMessage = 'Error while loggin in: ' + errResponse.data.errorMessage;
                            self.successMessage='';
                        }
                    );
            }
        }
    }
    ]);