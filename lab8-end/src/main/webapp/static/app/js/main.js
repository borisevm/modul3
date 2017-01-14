var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('myCtrl', function($scope){
	$scope.text = "hello world!";
	$scope.sayHello = function () {
		console.log('uneta poruka je: ',$scope.poruka);
	}
});

wafepaApp.controller('myCtrl1', function($scope){
	$scope.text="asdfasdfasd asdf asdf";
});

wafepaApp.controller('innerCtrl', function($scope){
	$scope.text = "Nova vrednost";
});

wafepaApp.controller('activityCtrl', 
  function($scope, $http,$location, $routeParams){
  $http.get('/api/activities/'+$routeParams.id).then(function (resp) {
   $scope.activity = resp.data;
  });


  $scope.sacuvaj=function () {
    //ako $scope.activity nema id, onda je novokreirana 
    if(!$scope.activity.id){
        $http.post('/api/activities/',$scope.activity).then(function () {
            $location.path('/activities');   
        });
    }
    //ako $scope.activity ima id, onda se menja postojeca aktivnost 
    else{
        $http.put('/api/activities/'+$scope.activity.id,$scope.activity).then(function () {
          $location.path('/activities');   
        });
    }

  }  
  
});

wafepaApp.controller('activitiesCtrl',function ($scope, $http, $location) {
    //preuzimanje svih aktivnosti
    var ucitajSve = function () {
       //config objekat pomogcu kog saljemo paramtri pretrage
       var config = {}
       //ako postoji fiterActivity.name, postavimo parametar pretrage
       if($scope.filterActivity&&$scope.filterActivity.name){
        config={'params':{'name':$scope.filterActivity.name}}
       }
       //then se pozove kada pristigne odgovor sa servera
       $http.get('/api/activities',config).then(function (resp) {
         $scope.activities = resp.data;
         $scope.activity={}
       });
    }       

   ucitajSve();
   
   $scope.filtriraj = ucitajSve;

   $scope.brisanje = function (id) {
	   $http.delete('/api/activities/'+id).then(ucitajSve) 
   }

   $scope.sacuvaj = function () {
    //ako $scope.activity nema id, onda je novokreirana 
    if(!$scope.activity.id){
        $http.post('/api/activities/',$scope.activity).then(ucitajSve);
    }
    //ako $scope.activity ima id, onda se menja postojeca aktivnost 
    else{
        $http.put('/api/activities/'+$scope.activity.id,$scope.activity).then(ucitajSve);
    }
   }

   $scope.postaviAktivnost = function (a) {
    //u $scope postavljamo kopiju aktivnosti 
    //da ne bi izmena aktivnosti u formi odmah menjala i
    //aktivnost u listi
    $scope.activity = angular.copy(a);
   }
   
   $scope.postaviAktivnostNaStranici = function(a) {
	   $scope.activity = angular.copy(a);
	   $location.path('/activity/'+$scope.activity.id);
   }
});

wafepaApp.controller('usersCtrl', function($scope, $http, $location) {
		var ucitajSve = function() {
			
			var config = {};
			if($scope.filterUser && $scope.filterUser.lastname) {
				config = {'params': {'lastname':$scope.filterUser.lastname}};
			}
			$http.get('/api/users', config).then(function(resp){
				$scope.users = resp.data;
				$scope.user = {}
			});
		}
		ucitajSve();
		
		$scope.filtriraj = ucitajSve; 
		
		$scope.brisanje = function(id) {
			$http.delete('/api/users/'+id).then(ucitajSve);
		}
		
		$scope.sacuvaj = function() {
			if(!$scope.user.id) {
				$http.post('/api/users/', $scope.user).then(ucitajSve);
			} else {
				$http.put('/api/users/'+$scope.user.id, $scope.user).then(ucitajSve);
			}
		}
		
		$scope.postaviUser = function(a) {
			$scope.user = angular.copy(a);
		}
		
		$scope.postaviUserNaStranici = function(a) {
			$scope.user = angular.copy(a);
			$location.path('/user/'+$scope.user.id);
		}
		
		$scope.emptyForm = {};
		$scope.reset = function() {
			$scope.user = angular.copy($scope.emptyForm);
		}
});

wafepaApp.controller('userCtrl', function($scope, $http, $location, $routeParams) {
	
		$http.get('/api/users/'+$routeParams.id).then(function(resp){
			$scope.user = resp.data;			
		});
		
	
	$scope.sacuvaj = function() {
		if(!$scope.user.id) {
			$http.post('/api/users/', $scope.user).then(function() {
				$location.path('/users');
			})
		} else {
			$http.put('/api/users/'+$scope.user.id, $scope.user).then(function() {
				$location.path('/users');
			});
		}
	}
	
	$scope.emptyForm = {};
	$scope.reset = function() {
		$scope.user = angular.copy($scope.emptyForm);
	}
});

//od Angular 1.6 default hash prefiks vise nije '' nego je '!'
//to znaci da putanja nece biti ...index.html/#/activities 
//nego ce biti index.html/#!/activities 
wafepaApp.config(function($routeProvider) {
    $routeProvider
        //http://localhost:8080/static/app/html/index.html/#!/
        .when("/", {
            templateUrl : '/static/app/html/partials/home.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/activities
        .when('/activities', {
             templateUrl : '/static/app/html/partials/activities.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/activity
        .when('/activity/:id', {
             templateUrl : '/static/app/html/partials/activity.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/users
        .when('/users', {
        	templateUrl : '/static/app/html/partials/users.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/user
        .when('/user/:id', {
        	templateUrl : '/static/app/html/partials/user.html'
        })
        //sve ostalo radi redirekciju na
        //http://localhost:8080/static/app/html/index.html/#!/
        .otherwise({
             redirectTo: '/'
        });

});