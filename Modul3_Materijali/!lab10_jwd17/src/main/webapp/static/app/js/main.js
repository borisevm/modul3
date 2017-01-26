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
  $scope.getAddressAsString = function(user){
    retVal = '';
    for (var i = 0; i < user.addresses.length; i++) {
      retVal += user.addresses[i].streat + ' ';
    };
    return retVal;
  }

  $scope.brojacStranice = 0;

  $scope.changePage = function (i) {
    if ($scope.brojacStranice>=0) {
      $scope.brojacStranice += i;
    }
    ucitajSve();
  };

    //preuzimanje svih aktivnosti
    var ucitajSve = function () {
       //config objekat pomogcu kog saljemo paramtri pretrage
       var config ={'params':{
        'page':$scope.brojacStranice
      }
    }

       //ako postoji fiterActivity.name, postavimo parametar pretrage
       if($scope.filterActivity&&$scope.filterActivity.name){
        config.params.name=$scope.filterActivity.name;
       }

       //then se pozove kada pristigne odgovor sa servera
       $http.get('/api/activities',config).then(function (resp) {
         $scope.activities = resp.data;
         $scope.totalPages = Number(resp.headers().totalpages);
         $scope.activity={}
       });
     }

     ucitajSve();

     $scope.filtriraj = function () {
       $scope.brojacStranice = 0;
       ucitajSve();
     } 

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

  $scope.postaviAktivnostNaStranici = function (activity) {
    $location.path('/activity/'+activity.id);   

  }
});

wafepaApp.controller('knjigeCtrl', function($scope, $http){


  var ucitajKnjige = function () {
    $http.get('/api/knjiga').then(function (resp) {
      $scope.knjige = resp.data;
    });
  }


  var ucitajAutore = function () {
    $http.get('/api/autori').then(function (resp) {
      $scope.autori = resp.data;
    });
  }


  ucitajKnjige();
  ucitajAutore();

  
    $scope.sacuvaj = function () {
    //ako $scope.activity nema id, onda je novokreirana 
    // if(!$scope.activity.id){
      $http.post('/api/knjiga/',$scope.knjiga).then(ucitajKnjige);
    // }
    //ako $scope.activity ima id, onda se menja postojeca aktivnost 
    // else{
      // $http.put('/api/activities/'+$scope.activity.id,$scope.activity).then(ucitajSve);
    // }
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
        //http://localhost:8080/static/app/html/index.html/#!/activity
        .when('/knjige', {
         templateUrl : '/static/app/html/partials/knjige.html'
       })
        //sve ostalo radi redirekciju na
        //http://localhost:8080/static/app/html/index.html/#!/
        .otherwise({
         redirectTo: '/'
       });

      });