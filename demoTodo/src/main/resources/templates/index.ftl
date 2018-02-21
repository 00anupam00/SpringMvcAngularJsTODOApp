<!DOCTYPE html>

<html lang="en" ng-app="todoApp">
<head>
    <title>${title}</title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/app.css" rel="stylesheet"/>
</head>
<body>

<div ui-view></div>
<script src="js/lib/angular.min.js" ></script>
<script src="js/lib/angular-ui-router.min.js" ></script>
<script src="js/lib/localforage.min.js" ></script>
<script src="js/lib/ngStorage.min.js"></script>
<script src="js/app/app.js"></script>
<script src="js/app/TaskService.js"></script>
<script src="js/app/TaskController.js"></script>
<script src="js/app/LoginController.js"></script>
<script src="js/app/LoginService.js"></script>
</body>
</html>