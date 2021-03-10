angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI){
        $scope.app = "Lista Telefônica";
        
        $scope.contatos = [];

        $scope.operadoras = [];

		var carregarContatos = function () {
			contatosAPI.getContatos().then(function sucessCallBack(response){
				$scope.contatos = response.data;
			}, function errorCallback(){
                alert("Ocorreu um erro")
            });
		};

        var carregarOperadoras = function () {
            operadorasAPI.getOperadoras().then(function sucessCallBack(response){
                $scope.operadoras = response.data;
            }, function errorCallback(){
                alert("Ocorreu um erro")
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