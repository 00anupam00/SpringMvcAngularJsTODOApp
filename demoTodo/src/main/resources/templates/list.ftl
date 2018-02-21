<div class="generic-container">
    <div class="panel panel-primary">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Manage your Task Here</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.Task.id" />
                    <#--<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.task.id" id="uname" class="username form-control input-sm" placeholder="Enter your task" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>-->

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="description">Description</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.Task.desc" id="description" class="form-control input-sm" placeholder="Enter your Description."/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="status">Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.Task.status" id="status" class="form-control input-sm" placeholder="Enter the Status."/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions center">
                            <input type="submit"  value="{{!ctrl.Task.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="generic-container">
    <div class="panel panel-primary">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Tasks </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>DESCRIPTION</th>
                        <th>STATUS</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllTasks()">
                        <td>{{u.id}}</td>
                        <td>{{u.desc}}</td>
                        <td>{{u.status}}</td>
                        <td><button type="button" ng-click="ctrl.editTask(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeTask(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>