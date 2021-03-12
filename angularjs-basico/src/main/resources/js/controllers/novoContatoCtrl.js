angular.module("listaTelefonica").controller("novoContatoCtrl", function ($scope, contatosAPI, $location, operadoras){

    $scope.operadoras = operadoras.data;

    $scope.adicionarContato = function (contato) {
        contato.data = new Date();
        contatosAPI.saveContato(contato).then(function sucessCallBack(){
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
            $location.path('/contato')
        }, function errorCallback(){
            alert("Ocorreu um erro")
        });
    };
    
});