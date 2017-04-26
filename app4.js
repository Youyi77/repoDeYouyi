

var app=angular.module('myModule',[]);
/*var ctrl = function($scope){
	$scope.message="Je suis l'essence même de la magie";


};*/



var tab=[	
			{nom:"Macdo",valeur1:0 , valeur2:0},
			{nom:"Monop",valeur1:0, valeur2:0},
			{nom:"Subway",valeur1:0, valeur2:0},
			{nom:"Chinois",valeur1:0, valeur2:0},
			{nom:"Pizza",valeur1:0, valeur2:0}      ];



var myF=function myFunction(x){
	console.log(x);
	x.valeur1 ++;
}

var myF2=function myFunction2(z){
	console.log(z);
	z.valeur2 ++;
}


app.controller('myCtrl',function($scope){ 	$scope.tab=tab; 
											$scope.myF=myF; 
											$scope.myF2=myF2; 
											$scope.w=0;			 });