/**
 * 
 */
var url = "http://localhost:8484/northwindj/";
var app = angular.module('northwind', [ 'ui.bootstrap', 'checklist-model' ]);
app.factory('$pageUtils', [
		'$http',
		function($http) {
			return {
				getUrlVars : function() {
					var vars = [], hash;
					var hashes = window.location.href.slice(
							window.location.href.indexOf('?') + 1).split('&');
					for (var i = 0; i < hashes.length; i++) {
						hash = hashes[i].split('=');
						vars.push(hash[0]);
						vars[hash[0]] = hash[1];
					}
					return vars;
				}
			};
		} ]);
app.factory('$CommonUtils', function() {
	var factory = {};
	factory.convertNullToObject = function(item) {
		if (item == null || item == undefined) {
			return {};
		} else {
			return item;
		}
	};
	factory.convertNullToArray = function(arr) {

		if (arr == null || arr == undefined) {
			return [];
		} else {
			return arr;
		}
	};
	return factory;
});