var myApp = angular.module('myApp', []);
myApp.controller('myCtrl', function($scope) {
    //    $scope.index=1;
    //将所有的东西存储在对象里面
    $scope.change = new Object();
    $scope.change.text = [{
        key: 0,
        value: ""
    }];
    //只有一个文本框时，不能删除
    $scope.change.canRemove = false;
    //动态添加
    $scope.change.add = function($index) {
        //添加文本框
            $scope.change.text.splice($index + 1, 0, {
                key: new Date().getTime(),
                value: ""
            });
            $scope.change.canRemove = true;

        }
    //动态减少
    $scope.change.remove = function($index) {
        //大于1时，直接删除
        if ($scope.change.text.length > 1) {
            $scope.change.text.splice($index, 1);
        }
        if ($scope.change.text.length == 1) {
            $scope.change.canRemove = false;
        }

    }


});
