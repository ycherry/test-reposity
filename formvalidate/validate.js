var myApp = angular.module('myApp', []);
myApp.controller('myAppCtrl', ['$scope','$filter', function($scope,$filter) {
    $scope.testLengthBlur=function() {
        console.log($scope.testForm.testLength);
    }
    $scope.phoneNumberPattern="/(^\d{3}-\d{3}-\d{4}$)/";
    // $scope.phoneNumberInput=function(){
    //     $scope.phoneNumber=$filter('phoneNumberPattern')($scope.phoneNumber);
    // }

}]);
