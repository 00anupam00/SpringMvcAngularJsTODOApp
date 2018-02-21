var app = angular.module('todoApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8010/todoDemoApp',
    TASK_SERVICE_API : 'http://localhost:8010/todoDemoApp/tasks/',
    LOGIN_SERVICE_API : 'http://localhost:8010/todoDemoApp/validate'
}, 'login','');

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('validate', {
                url: '/validate',
                templateUrl: 'partials/list',
                controller:'TaskController',
                controllerAs:'ctrl',
                resolve: {
                    tasks: function ($q, TaskService) {
                        console.log('Load all tasks');
                        var deferred = $q.defer();
                        TaskService.loadAllTasks().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            }).state('login',{
                url: '/login',
                templateUrl: 'partials/login',
                controller: 'LoginController',
                controllerAs: 'loginctrl'
                /*resolve: {
                    tasks: function($q, LoginService){
                        console.log('Verifying login.');
                        /!*var deferred = $q.defer();*!/
                        /!*LoginService.validateLogin().then(deferred.resolve,  deferred.resolve);*!/
                        return deferred.promise;
                    }
                }*/
        }).state('home', {
            url: '/',
            templateUrl: 'partials/login',
            controller:'LoginController',
            controllerAs:'loginctrl'
            /*resolve: {
                tasks: function ($window) {
                    $window.location.href = '/login';
                    return deferred.promise;
                }
            }*/
        });
        $urlRouterProvider.otherwise('/login');
    }]);
