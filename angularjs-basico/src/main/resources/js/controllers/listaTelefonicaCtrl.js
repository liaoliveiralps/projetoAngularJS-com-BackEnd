angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI){
        $scope.app = "Lista Telefônica";
        
        $scope.contatos = [];

        $scope.operadoras = [];

		var carregarContatos = function () {
            contatosAPI.getContatos().then(function (response) {
                $scope.contatos = response.data;
            }, function (error) {
                $scope.error = "Não foi possível carregar os dados!";
                }
            );
        };

        var carregarOperadoras = function () {
            operadorasAPI.getOperadoras().then(function sucessCallBack(response){
                $scope.operadoras = response.data;
            });
        };

        $scope.adicionarContato = function (contato) {
            contato.data = new Date();
            contatosAPI.saveContato(contato).then(function sucessCallBack(){
				delete $scope.contato;
           		$scope.contatoForm.$setPristine();
				carregarContatos();
            }, function errorCallback(){
                alert("Ocorreu um erro")
            });
        };

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

		carregarContatos();
        carregarOperadoras();
});