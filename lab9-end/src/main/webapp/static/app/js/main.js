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

//$http servis - komunikacija sa Rest serverom putem Ajax poziva 
//$Location servis - redirekcija putem URL adrese kao parametra na druge srenice (poglede) u okviru SPA
//$routeParams servis - služi za čitanje parametara rute
//.then - akcija koja se izvršava nakon uspešnog izvršenja prethodne akcije 
wafepaApp.controller('activityCtrl', 
  function($scope, $http, $location, $routeParams){
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

wafepaApp.controller('activitiesCtrl', function($scope, $http, $location) {

  //funkcija za dobavljanje elemenata niza za prikaz u angular izrazu na html stranici
  $scope.getAddressAsString = function(user){
    retVal = '';
    for (var i = 0; i < user.addresses.length; i++) {
      retVal += user.addresses[i].street + ' ' + user.addresses[i].number + ' ';
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
       //config objekat pomocu kog saljemo paramtri pretrage. 
       //definisanje broja stranice kao parametra za pretragu
       var config ={'params':{
        'page':$scope.brojacStranice
      }
    }

       //ako postoji fiterActivity.name, postavimo parametar pretrage
       //Nakon inicijalizacije (koja nije prazan objekat) može se koristiti i anotacija "config.params.name=$scope.filterActivity.name"
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

wafepaApp.controller('usersCtrl', function($scope, $http, $location) {

  $scope.brojacStranice = 0;

  $scope.changePage = function(i) {
    if($scope.brojacStranice >= 0) {
      $scope.brojacStranice += i;
    }
    ucitajSve();
  };

  var ucitajSve = function() {
    var config = {'params' : {'page' : $scope.brojacStranice}}

    if($scope.filterUser && $scope.filterUser.name) {
      config.params.name = $scope.filterUser.name;
    }
    $http.get('/api/users', config).then( function(resp) {
      $scope.users = resp.data;
      $scope.totalPages = Number(resp.headers().totalpages); //response promenljive su low case
      $scope.user = {};
    });
  }

  ucitajSve();

  $scope.filtriraj = function() {
    $scope.brojacStranice = 0;
    ucitajSve();
  }

  $scope.brisanje = function(id) {
    $http.delete('/api/users/'+id).then( function() {
      if($scope.brojacStranice >= $scope.totalPages-1) {
        $scope.brojacStranice --; 
      }
      ucitajSve();
    });
  }
  
  $scope.sacuvaj = function() {
    if(!$scope.user.id) {
      $http.post('/api/users', $scope.user).then(ucitajSve);
    } else {
      $http.put('/api/users/' + $scope.user.id, $scope.user).then(ucitajSve);
    }
  }

  $scope.postaviUser = function(a) {
    $scope.user = angular.copy(a);
  }

  $scope.postaviUserNaStranici = function(a) {
    $scope.user = angular.copy(a);
    $location.path('/user/' + a.id)
  }

  $scope.emptyForm = {};
  $scope.reset = function() {
    $scope.user = angular.copy($scope.emptyForm);
  }

});

wafepaApp.controller('userCtrl', function($scope, $http, $location, $routeParams) {

  $http.get('/api/users/'+$routeParams.id).then( function(resp) {
    $scope.user = resp.data;
  });

  $scope.sacuvaj = function() {

    if(!$scope.user.id) {
      $http.post('/api/users', $scope.user).then( function() {
        $location.path('/users');
      })
    }
  }

  $scope.emptyForm = {};
  $scope.reset = function() {
    $scope.user = angular.copy($scope.emptyForm);
  }

});

//Konfigurisanje $routeProvider servisa - prethodno je potrebno dobaviti angular-route.js i dodati ngRoute modul u aplikaciju kao dependency
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