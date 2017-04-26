var app=angular.module('myModule',[]);

app.controller('myCtrl',function($scope){
	var photo={
	nom:"collection",
	lieu:"paris",
	path:"../../../Image2.jpg"
};
	$scope.photo=photo;

} );