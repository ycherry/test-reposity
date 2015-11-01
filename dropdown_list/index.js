var mySelectModule = angular.module('mySelectModule', []);
mySelectModule.run(function() {
    // angular.element("#mySelect").selectpicker();

});
mySelectModule.controller('mySelectCtrl', ['$scope', function($scope) {
    $scope.selected = "";
    $scope.selectOption = {
        id: "1",
        value: ['zero', 'one', 'two', 'three']
    }
    $scope.options = ['zero', 'one', 'two', 'three'];
    $scope.change = function() {
        console.log($scope.selected);
    }

}]);
