var advertisementsApp = angular.module('advertisementsApp', ['smart-table', 'ngRoute']);

advertisementsApp.controller('advertisementsCtrl', function($scope, $http, $location){

	$scope.pageCounter = 0;

	$scope.changePage = function(i) {
		if($scope.pageCounter >= 0) {
			$scope.pageCounter += i;			
		}
		loadAdvertisements();		
	}

	var loadAdvertisements = function() {

		//inicijalno konfigurisanje parametra (za broj strane)
		var config = {'params': {
			'page' : $scope.pageCounter
			}
		}

		//konfigurisanje parametra za pretragu po naslovu
		if($scope.filterAdvertisement&&$scope.filterAdvertisement.adresa) {
			config.params.category = $scope.filterAdvertisement.category;
		}
		if($scope.filterAdvertisement&&$scope.filterAdvertisement.dateEnd) {
			config.params.dateEnd = $scope.filterAdvertisement.dateEnd;
		}
		if($scope.filterAdvertisement&&$scope.filterAdvertisement.keyword) {
			config.params.keyword = $scope.filterAdvertisement.keyword;
		}
		

		$http.get('/api/advertisements', config).then(function(resp){
			$scope.advertisements = resp.data;
			$scope.totalPages = Number(resp.headers().totalpages);
			//$scope.advertisement = {};
		});
	}
	

	loadAdvertisements();
//	loadCategories();

	$scope.editAdvertisement = function(k) {
		$scope.advertisement = angular.copy(k);
		$scope.selected = function(a, k) {
			if (a==k) {
				return a;
			}
		}
	};

	$scope.delete = function(id) {
		$http.delete('/api/advertisements/'+id).then(function() {
      		if($scope.pageCounter >= $scope.totalPages-1) {
        	$scope.pageCounter--;        
      }
      loadAdvertisements();
      });
	}

	$scope.save = function() {
		if(!$scope.advertisement.id) {
			$http.post('/api/advertisements/', $scope.advertisement).then(function() {
				loadAdvertisements();
				$scope.advertisement = angular.copy($scope.emptyForm);
			});
		} else {
			$http.put('/api/advertisements/'+$scope.advertisement.id, $scope.advertisement).then(function() {
				loadAdvertisements();
				$scope.advertisement = angular.copy($scope.emptyForm);
			});
		}
	}

	$scope.filtriraj = function() {
		$scope.pageCounter = 0;
		loadAdvertisements();
	}

	$scope.editAdvertisementOnPage = function(advertisement) {
		//ucitajService.setAutori($scope.autori);
		$location.path('/advertisement/'+advertisement.id);		
	}

	//reset funkcija
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.advertisement = angular.copy($scope.emptyForm);
	}
	

});

advertisementsApp.controller('categoriesCtrl', function($scope, $http, $location){

var loadCategories = function() {
		
		$http.get('/api/categories').then(function(resp){
			$scope.categories = resp.data;	
			$scope.displayedCollection = [].concat($scope.categories);		
		});
	}
loadCategories();	



});

advertisementsApp.config(function($routeProvider) {
	$routeProvider
		//http://localhost:8080/static/app/html/index.html/#!/
		.when('/', {
			templateUrl: '/static/app/html/partials/advertisements.html'
		})
		//http://localhost:8080/static/app/html/index.html/#!/categories.html
		.when('/categories', {
			templateUrl: '/static/app/html/partials/categories.html'
		})		
		.otherwise({
			redirectTo: '/'
		});
});
