angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatos){
        $scope.app = "Lista Telefônica";
        
        $scope.contatos = contatos.data;

        $scope.operadoras = [];

        $scope.apagarContatos = function (contatos) {
            $scope.contatos = contatos.filter(function (contato) {
                if(!contato.selecionado) return contato;
            });
            
        };

        $scope.isContatoSelecionado = function (contatos) {
            return contatos.some(function (contato){
                return contato.selecionado;
            });
        };

        $scope.ordernarPor = function (campo) {
            $scope.criterioDeOrdenacao = campo;
            $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
        };

});