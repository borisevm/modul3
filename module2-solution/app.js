(function() {
  'use strict';
  var toBuyItems = [
    {
    name: "Wine",
    quantity: "2 bottles"
  },
  {
    name: "Beer",
    quantity: "10 cans"
  },
  {
    name: "Cookies",
    quantity: "5 bags"
  },
  {
    name: "Coffee",
    quantity: "3 packs"
  },
  {
    name: "Juice",
    quantity: "5 liters"
  }];
  var boughtItems = [];

  angular.module('ShoppingListCheckOff', [])
  .controller('ToBuyController', ToBuyController)
  .controller('AlreadyBoughtController', AlreadyBoughtController)
  .service('ShoppingListCheckOffService', ShoppingListCheckOffService);

  ToBuyController.$inject = [];
  function ToBuyController() {
    var toBuy = this;
    toBuy.itemsToBuy = toBuyItems;
    toBuy.removeFromList = function(id) {
      toBuy.prikaz = toBuy.itemsToBuy[id];
    }
  };

  AlreadyBoughtController.$inject = ['$scope'];
  function AlreadyBoughtController($scope) {

  };

  function ShoppingListCheckOffService() {
    var service = this;

  };

})();
