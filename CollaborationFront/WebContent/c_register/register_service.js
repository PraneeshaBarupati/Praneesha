'use strict';
 
app.factory('RegistrationService', ['$http', '$q', function($http, $q){
	console.log("RegistrationService...")
    return {
         
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8081/CollaborationBackEnd/UserDetails')
                            .then(
                                    function(response){
                                    	console.log('fetchAllUsers response:' +response.data)
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching UserDetailss');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createUser: function(UserDetails){
            	console.log('createUser UserDetails' + UserDetails)
            	var jsonObject = angular.toJson(UserDetails)
            	console.log('toJson:' + jsonObject)
                    return $http.post('http://localhost:8081/CollaborationBackEnd/UserDetails/', jsonObject)
                            .then(
                                    function(response){
                                    	console.log('createUser response:' +response.data)
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating UserDetails');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateUser: function(UserDetails, id){
            	console.log('updateUser UserDetails' + UserDetails)
                    return $http.put('http://localhost:8081/CollaborationBackEnd/UserDetails/'+id, UserDetails)
                            .then(
                                    function(response){
                                    	console.log('createUser :' +response.data)
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating UserDetails');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteUser: function(id){
            	console.log('deleteUser id' + id)
                    return $http.delete('http://localhost:8081/CollaborationBackEnd/UserDetails/'+id)
                            .then(
                                    function(response){
                                    	console.log('deleteUser :' +response.data)
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting UserDetails');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);