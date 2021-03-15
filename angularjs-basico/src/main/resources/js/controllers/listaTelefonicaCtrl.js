angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatos, $filter){
        $scope.app = $filter('upper')("Lista Telefônica");
        
        $scope.contatos = contatos.data;

        $scope.operadoras = [];

        $scope.apagarContatos = function (contatos) {
            $scope.contatos = contatos.filter(function (contato) {
                if(!contato.selecionado) return contato;
            });
            $scope.verificarContatoSelecionado($scope.contatos);
        };

        $scope.verificarContatoSelecionado = function (contatos) {
            $scope.hasContatoSelecionado = contatos.some(function (contato) {
                return contato.selecionado;
            });
        };

        $scope.ordernarPor = function (campo) {
            $scope.criterioDeOrdenacao = campo;
            $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
        };

});