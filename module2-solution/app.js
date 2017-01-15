(function() {
  'use strict';


  angular.module('ShoppingListCheckOff', [])
  .controller('ToBuyController', ToBuyController)
  .controller('AlreadyBoughtController', AlreadyBoughtController)
  .service('ShoppingListCheckOffService', ShoppingListCheckOffService);

  ToBuyController.$inject = ['ShoppingListCheckOffService'];
  function ToBuyController(ShoppingListCheckOffService) {
    var toBuy = this;
    toBuy.itemsToBuy = ShoppingListCheckOffService.getItems();
    toBuy.removeFromList = function(id) {
      return ShoppingListCheckOffService.removeItem(id)
    }
  };

  AlreadyBoughtController.$inject = ['ShoppingListCheckOffService'];
  function AlreadyBoughtController(ShoppingListCheckOffService) {
    var bought = this;
  };

  function ShoppingListCheckOffService() {
    var service = this;

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

    service.removeItem = function (id) {
      toBuyItems.splice(id, 1);
    };

    service.addItem = function(item) {
      boughtItems.push(item);
    };

    service.getItems = function () {
      return toBuyItems;
    };

    service.moveToBought = function(id) {
      toBuyItems.splice(id, 1);
    }

  };

})();
