
var app = angular.module("app", ["ngRoute", 'ngSanitize']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
    	templateUrl : "page/home.html"
    })
    .when("/customers", {
        templateUrl : "http://localhost:9092/customer-portal/"
    })
    .when("/product", {
        templateUrl : "http://localhost:9093/product-portal/"
    })
    .otherwise({
        redirectTo: '/'
    });
});

app.controller('MainCtrl', function($scope, $sce) {
  $scope.trustSrc = function(src) {
    return $sce.trustAsResourceUrl(src);
  }

  $scope.customers = {src:"http://localhost:9092/customer-portal/", title:"Egghead.io AngularJS Binding"};
});