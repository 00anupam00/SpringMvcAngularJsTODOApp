'use strict';

angular.module('todoApp').controller('TaskController',
    ['TaskService', '$scope', function( TaskService, $scope) {

        var self = this;
        self.Task = {};
        self.Tasks=[];

        self.submit = submit;
        self.getAllTasks = getAllTasks;
        self.createTask = createTask;
        self.updateTask = updateTask;
        self.removeTask = removeTask;
        self.editTask = editTask;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.Task.id === undefined || self.Task.id === null) {
                console.log('Saving New Task', self.Task);
                createTask(self.Task);
            } else {
                updateTask(self.Task, self.Task.id);
                console.log('Task updated with id ', self.Task.id);
            }
        }

        function createTask(Task) {
            console.log('About to create Task');
            TaskService.createTask(Task)
                .then(
                    function (response) {
                        console.log('Task created successfully');
                        self.successMessage = 'Task created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.Task={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Task');
                        self.errorMessage = 'Error while creating Task: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateTask(Task, id){
            console.log('About to update Task');
            TaskService.updateTask(Task, id)
                .then(
                    function (response){
                        console.log('Task updated successfully');
                        self.successMessage='Task updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Task');
                        self.errorMessage='Error while updating Task '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeTask(id){
            console.log('About to remove Task with id '+id);
            TaskService.removeTask(id)
                .then(
                    function(){
                        console.log('Task '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Task '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllTasks(){
            return TaskService.getAllTasks();
        }

        function editTask(id) {
            self.successMessage='';
            self.errorMessage='';
            TaskService.getTask(id).then(
                function (Task) {
                    self.Task = Task;
                },
                function (errResponse) {
                    console.error('Error while removing Task ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.Task={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);