var myModule = angular.module('myModule', []);
angular.module('myModule').controller('myCtrl', ['$scope', function($scope) {
    $scope.sNumber = Number($scope.sNumber);
}]);
myModule.directive('stars', function() {
    return {
        restrict: 'E',
        templateUrl: 'assessmentStars.html',
        scope: {
            starNumber: '='
        },
        controller: function($scope) {
            $scope.starNumber = Number($scope.starNumber);
            console.log( $scope.starNumber);
        }
    }

});
