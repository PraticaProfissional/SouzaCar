/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular
      .module('SouzaCar.pages.financial', ['ui.select', 'ngSanitize'])
      .config(routeConfig)
      .constant('accountType', accountType);

  function accountType(){
    return {
      list:{
        'ENTRADA': 'Income',
        'ATIVO': 'Expense',
        'PASSIVO': 'Assets',
        'SAIDA': 'Liabilities'
      },
      get: function( value ){
        return this.list[value]
      }
    }
  }

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('financial', {
          url: '/financial',
          template : '<ui-view autoscroll="true" autoscroll-body-top></ui-view>',
          abstract: true,
          title: 'Financial',
          sidebarMeta: {
            icon: 'fa fa fa-dollar',
            order: 250,
          },
        })
        .state('financial.dashboard', {
          url: '/dashboard',
          templateUrl: 'app/pages/financial/dashboard/dashboard.html',
          title: 'Dashboard',
          sidebarMeta: {
            order: 0,
          },
        })
        .state('financial.accounts', {
          url: '/accounts',
          templateUrl: 'app/pages/financial/accounts/accounts.html',
          controller: 'FinancialAccountsController',
          controllerAs: 'vm',
          title: 'Accounts',
          sidebarMeta: {
            order: 100,
          },
        })
        .state('financial.entries',
        {
          url: '/entries',
          templateUrl: 'app/pages/financial/entries/entries.html',
          controller: 'FinancialEntriesController',
          controllerAs: 'vm',
          title: 'Entries',
          sidebarMeta: {
            order: 200,
          },
        });
  }
})();
