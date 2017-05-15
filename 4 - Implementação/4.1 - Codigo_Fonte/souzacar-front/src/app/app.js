(function ()
{
    'use strict';

    angular
        .module('SouzaCar', [
          'ngResource',
          'ngAnimate',
          'ui.bootstrap',
          'ui.sortable',
          'ui.router',
          'ngTouch',
          'toastr',
          'smart-table',
          "xeditable",
          'ui.slimscroll',
          'ngJsTree',
          'angular-progress-button-styles',

          'SouzaCar.theme',
          'SouzaCar.pages'
        ]);

})();