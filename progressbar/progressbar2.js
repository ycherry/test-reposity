var myModule = angular.module('myModule', []);
myModule.controller('myCtrl',['$scope',function($scope) {
    $scope.myWidth = {
        width:"80%"
    };
    $scope.myWidthNumber = '80 % ';
}]);
