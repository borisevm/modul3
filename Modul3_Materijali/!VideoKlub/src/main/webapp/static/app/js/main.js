var videoklubApp = angular.module('videoklubApp', ['ngRoute']);

videoklubApp.controller('clanoviCtrl', function($scope, $http) {
	
	$scope.brojacStranice = 0;

	$scope.changePage = function(i) {
		if($scope.brojacStranice >= 0) {
			$scope.brojacStranice += i;			
		}
		ucitajClanove();
	}	

	var ucitajClanove = function() {

		var config = {'params' : {
			'page' : $scope.brojacStranice}
		}

		if($scope.filterClan&&$scope.filterClan.name) {
			config.params.name = $scope.filterClan.name;
		}

		$http.get('/api/clanovi', config).then(function(resp){
			$scope.clanovi = resp.data;
			$scope.totalPages = Number(resp.headers().totalpages);	
			//$scope.clan = {};
		});
	}
	ucitajClanove();

	$scope.izmeni = function(a) {
		$scope.clan = angular.copy(a);	
	}

	$scope.brisanje = function(id) {		
		$http.delete('/api/clanovi/'+id).then( function() {
      		if($scope.brojacStranice >= $scope.totalPages-1) {
        	$scope.brojacStranice --; 
      }
      ucitajClanove();
	});
	}

	$scope.sacuvaj = function() {
		if(!$scope.clan.id) {
			$http.post('/api/clanovi/', $scope.clan).then( function() {
				ucitajClanove();
				$scope.clan = angular.copy($scope.emptyForm);
			});	
		} else {
			$http.put('/api/clanovi/'+$scope.clan.id, $scope.clan).then( function() {
				ucitajClanove();
				$scope.clan = angular.copy($scope.emptyForm);
			});
		}
	}

	$scope.filtriraj = function() {
		$scope.brojacStranice = 0;
		ucitajClanove();
	}

	//reset funkcija
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.clan = angular.copy($scope.emptyForm);
	}
	
});

videoklubApp.config(function($routeProvider) {
	$routeProvider
		//http://localhost:8080/static/app/html/index.html/#!/
		.when('/', {
			templateUrl: '/static/app/html/partials/clanovi.html'
		})
		//http://localhost:8080/static/app/html/index.html/#!/clan.html
		.when('/clan/:id', {
			templateUrl: '/static/app/html/partials/clan.html'
		})		
		.otherwise({
			redirectTo: '/'
		});
});