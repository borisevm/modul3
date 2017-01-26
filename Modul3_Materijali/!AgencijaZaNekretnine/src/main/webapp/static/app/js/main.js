var agencijaApp = angular.module('agencijaApp', ['ngRoute']);

agencijaApp.controller('nekretnineCtrl', function($scope, $http, $location){

	$scope.brojacStranice = 0;

	$scope.changePage = function(i) {
		if($scope.brojacStranice >= 0) {
			$scope.brojacStranice += i;			
		}
		ucitajNekretnine();		
	}

	var ucitajNekretnine = function() {

		//inicijalno konfigurisanje parametra (za broj strane)
		var config = {'params': {
			'page' : $scope.brojacStranice
			}
		}

		//konfigurisanje parametra za pretragu po naslovu
		if($scope.filterNekretnina&&$scope.filterNekretnina.adresa) {
			config.params.adresa = $scope.filterNekretnina.adresa;
		}
		

		$http.get('/api/nekretnine', config).then(function(resp){
			$scope.nekretnine = resp.data;
			$scope.totalPages = Number(resp.headers().totalpages);
			//$scope.nekretnina = {};
		});
	}

	var ucitajTipNekretnine = function() {
		
		$http.get('/api/tipnekretnine').then(function(resp){
			$scope.tipoviNekretnine = resp.data;			
		});
	}

	ucitajNekretnine();
	ucitajTipNekretnine();

	$scope.izmeniNekretninu = function(k) {
		$scope.nekretnina = angular.copy(k);
		$scope.selected = function(a, k) {
			if (a==k) {
				return a;
			}
		}
	};

	$scope.brisanje = function(id) {
		$http.delete('/api/nekretnine/'+id).then(ucitajNekretnine);
	}

	$scope.sacuvaj = function() {
		if(!$scope.nekretnina.id) {
			$http.post('/api/nekretnine/', $scope.nekretnina).then(function() {
				ucitajNekretnine();
				$scope.nekretnina = angular.copy($scope.emptyForm);
			});
		} else {
			$http.put('/api/nekretnine/'+$scope.nekretnina.id, $scope.nekretnina).then(function() {
				ucitajNekretnine();
				$scope.nekretnina = angular.copy($scope.emptyForm);
			});
		}
	}

	$scope.filtriraj = function() {
		$scope.brojacStranice = 0;
		ucitajNekretnine();
	}

	$scope.izmeniNekretninuNaStrani = function(nekretnina) {
		//ucitajService.setAutori($scope.autori);
		$location.path('/nekretnina/'+nekretnina.id);		
	}

	//reset funkcija
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.nekretnina = angular.copy($scope.emptyForm);
	}

});

agencijaApp.controller('nekretninaCtrl', function($scope, $http, $location, $routeParams){
	$http.get('/api/nekretnine/'+$routeParams.id).then(function(resp){
			$scope.nekretnina = resp.data;			
		});

	var ucitajTipNekretnine = function() {
		
		$http.get('/api/tipnekretnine').then(function(resp){
			$scope.tipoviNekretnine = resp.data;			
		});
		$scope.selected = function(a, k) {
			if (a==k) {
				return a;
			}
		}
	}
	ucitajTipNekretnine();

	$scope.sacuvaj = function() {
		if(!$scope.nekretnina.id) {
			$http.post('/api/nekretnine/', $scope.nekretnina).then(function() {
				$location.path('/nekretnine');
				//$scope.nekretnina = angular.copy($scope.emptyForm);
			});
		} else {
			$http.put('/api/nekretnine/'+$scope.nekretnina.id, $scope.nekretnina).then(function() {
				$location.path('/nekretnine');
				//$scope.nekretnina = angular.copy($scope.emptyForm);
			});
		}
	}

	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.nekretnina = angular.copy($scope.emptyForm);
	}	

});	

agencijaApp.config(function($routeProvider) {
	$routeProvider
		//http://localhost:8080/static/app/html/index.html/#!/
		.when('/', {
			templateUrl: '/static/app/html/partials/nekretnine.html'
		})
		//http://localhost:8080/static/app/html/index.html/#!/nekretnina.html
		.when('/nekretnina/:id', {
			templateUrl: '/static/app/html/partials/nekretnina.html'
		})		
		.otherwise({
			redirectTo: '/'
		});
});