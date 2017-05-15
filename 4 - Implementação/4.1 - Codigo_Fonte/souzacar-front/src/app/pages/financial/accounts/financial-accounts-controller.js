(function () {
  'use strict';

  angular.module('SouzaCar.pages.financial')
      .controller('FinancialAccountsController', FinancialAccountsController);

  /** @ngInject */
  function FinancialAccountsController($scope, api, accountType, toastr) {
      
    var vm = this;

    //Variables
    var _currenIndex = null;

    vm.accountTypes = accountType();
    vm.accounts     = [];

    //Methods  
    vm.list     = list;
    vm.save     = save;
    vm.edit     = edit;
    vm.cancel   = cancel;

    //Implementation
    init();
    function init(){
        _resetValues();
        list();
    }

    function _resetValues(){
        if( vm.newAccountForm )
            vm.newAccountForm.$setPristine();

        _currenIndex = null;
        vm.account = { 
            accountTypes: vm.accountTypes.list[0],
            isActive: true
        };
    }
    
    /**
     * 
     */
    function list(){
        function callback( result ){ 
            vm.accounts = result.data.data; 
        }
        api.financial.account.get().then( callback );
    }

    /**
     * 
     */
    function save(){

        if( vm.newAccountForm.$invalid ){
            return;
        }

        function callback( result ){

            if( _currenIndex >= 0 )
                vm.accounts[ _currenIndex ] = result.data.data;
            else    
                vm.accounts.unshift( result.data.data );

            _resetValues();

            toastr.success('', 'The account has been saved', {
                "positionClass": "toast-top-right",
                "type": "success",
                "timeOut": "5000",
            });
        }

        if( vm.account.id )
            api.financial.account.put( vm.account ).then( callback );
        else
            api.financial.account.post( vm.account ).then( callback );
    }

    /**
     * 
     */
    function edit( index ){
        _currenIndex = index;
        vm.account   = angular.copy(vm.accounts[index]);
    }

    /**
     * 
     */
    function cancel(){
        _resetValues();    
    }


  }

})();

// vm.datePickerOpened     = false;
// vm.datePickerFormat     = 'dd/MM/yyyy';
// vm.datePickerOptions = {
//     showWeeks: false
// };
// function openDatePicker() {
//     vm.datePickerOpened = true;
// }
// vm.openDatePicker = openDatePicker;