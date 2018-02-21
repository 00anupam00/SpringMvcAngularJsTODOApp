<div class="generic-container">
    <h2>Login</h2>
    <div class="alert alert-success" role="alert" ng-if="loginctrl.successMessage">{{loginctrl.successMessage}}</div>
    <form class="form-horizontal" ng-submit="loginctrl.submit()">
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input ng-model="loginctrl.login.uname" type="text" class="form-control" id="uname" placeholder="Enter userName" name="uname">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input ng-model="loginctrl.login.password" type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
