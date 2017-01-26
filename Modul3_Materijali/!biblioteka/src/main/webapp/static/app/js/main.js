var bibliotekaApp = angular.module('bibliotekaApp', ['ngRoute']);

bibliotekaApp.controller('knjigeCtrl', 
		function($scope, $http, $location, ucitajService) {
	
	$scope.brojacStranice = 0;

	$scope.changePage = function(i) {
		if($scope.brojacStranice >= 0) {
			$scope.brojacStranice += i;			
		}
		ucitajKnjige();
		//ucitajAutore();
	}

	var ucitajKnjige = function() {

		//inicijalno konfigurisanje parametra (za broj strane)
		var config = {'params': {
			'page' : $scope.brojacStranice
			}
		}

		//konfigurisanje parametra za pretragu po naslovu
		if($scope.filterKnjiga&&$scope.filterKnjiga.name) {
			config.params.naslov = $scope.filterKnjiga.name;
		}
		

		$http.get('/api/knjige', config).then(function(resp){
			$scope.knjige = resp.data;
			$scope.totalPages = Number(resp.headers().totalpages);
		});
	}

	var ucitajAutore = function() {
		var config = {'params': {
			'page' : -1}
			}
		$http.get('/api/autori', config).then(function(resp){
			$scope.autori = resp.data;			
		});
	}
	
	ucitajKnjige();
	ucitajAutore();
	

	//postavlja vrednosti izabrane knjige u tekst polja
	$scope.izmeniKnjigu = function(k) {
		$scope.knjiga = angular.copy(k);
		$scope.selected = function(a, k) {
			if (a==k) {
				return a;
			}
		}
	}

	$scope.brisanje = function(id) {
		$http.delete('/api/knjige/'+id).then(ucitajKnjige);
	}

	$scope.sacuvaj = function() {
		if(!$scope.knjiga.id) {
			$http.post('/api/knjige/', $scope.knjiga).then(ucitajKnjige);
		} else {
			$http.put('/api/knjige/'+$scope.knjiga.id, $scope.knjiga).then(ucitajKnjige);
		}
	}

	$scope.filtriraj = function() {
		$scope.brojacStranice = 0;
		ucitajKnjige();
	}

	$scope.izmeniKnjiguNaStrani = function(knjiga) {
		ucitajService.setAutori($scope.autori);
		$location.path('/knjiga/'+knjiga.id);		
	}	

	//reset funkcija
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.knjiga = angular.copy($scope.emptyForm);
	}
});

bibliotekaApp.controller('knjigaCtrl', function($scope, $http, $location, $routeParams, ucitajService){
	$http.get('/api/knjige/'+$routeParams.id).then(function(resp){
			$scope.knjiga = resp.data;
//			$scope.totalPages = Number(resp.headers().totalpages);
			
		});
	$scope.autori = ucitajService.getAutori();
	//funkcija za inicijalizaciju select liste
	$scope.selected = function(a, k) {
		if (a==k) {
			return a;
		}
	};

	$scope.sacuvaj = function() {
		$http.put('/api/knjige/'+$scope.knjiga.id, $scope.knjiga).then(function() {
			$location.path('/api/knjige');
		});
	}
});

bibliotekaApp.controller('autoriCtrl', function($scope, $http) {
	
	$scope.brojacStranice = 0;

	$scope.changePage = function(i) {
		if($scope.brojacStranice >= 0) {
			$scope.brojacStranice += i;			
		}
		ucitajAutore();
	}	

	var ucitajAutore = function() {

		var config = {'params' : {
			'page' : $scope.brojacStranice}
		}

		if($scope.filterAutor&&$scope.filterAutor.name) {
			config.params.name = $scope.filterAutor.name;
		}

		$http.get('/api/autori', config).then(function(resp){
			$scope.autori = resp.data;
			$scope.totalPages = Number(resp.headers().totalpages);	
			//$scope.autor = {};
		});
	}
	ucitajAutore();

	$scope.izmeniAutora = function(a) {
		$scope.autor = angular.copy(a);	
	}

	$scope.brisanje = function(id) {		
		$http.delete('/api/autori/'+id).then( function() {
      		if($scope.brojacStranice >= $scope.totalPages-1) {
        	$scope.brojacStranice --; 
      }
      ucitajAutore();
	});
	}

	$scope.sacuvaj = function() {
		if(!$scope.autor.id) {
			$http.post('/api/autori/', $scope.autor).then( function() {
				ucitajAutore();
				$scope.autor = angular.copy($scope.emptyForm);
			});	
		} else {
			$http.put('/api/autori/'+$scope.autor.id, $scope.autor).then( function() {
				ucitajAutore();
				$scope.autor = angular.copy($scope.emptyForm);
			});
		}
	}

	$scope.filtriraj = function() {
		$scope.brojacStranice = 0;
		ucitajAutore();
	}

	//reset funkcija
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.autor = angular.copy($scope.emptyForm);
	}
	
});

bibliotekaApp.service('ucitajService', function (){
	var service = this;
	var autori;
	service.setAutori = function(a) {
		autori = a;
	}
	service.getAutori = function() {
		return autori;
	}

});

bibliotekaApp.config(function($routeProvider) {
	$routeProvider
		//http://localhost:8080/static/app/html/index.html/#!/
		.when('/', {
			templateUrl: '/static/app/html/partials/knjige.html'
		})
		//http://localhost:8080/static/app/html/index.html/#!/knjiga.html
		.when('/knjiga/:id', {
			templateUrl: '/static/app/html/partials/knjiga.html'
		})
		//http://localhost:8080/static/app/html/index.html/#!/autori.html
		.when('/autori', {
			templateUrl: '/static/app/html/partials/autori.html'
		})
		.otherwise({
			redirectTo: '/'
		});
});