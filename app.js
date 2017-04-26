

var app=angular.module('myModule',[]);
/*var ctrl = function($scope){
	$scope.message="Je suis l'essence même de la magie";


};*/
var tab=[	
			{nom:"boumaza",prenom:"adel", date:new Date()},
			{nom:"aa",prenom:"aaa", date:new Date()},
			{nom:"bb",prenom:"bbb", date:new Date()},
			{nom:"cc",prenom:"ccc", date:new Date()},
			{nom:"ww",prenom:"www", date:new Date()}      ];


app.controller('myCtrl',function($scope){  $scope.message="Je suis l'essence même de la magie";$scope.tab=tab;} );