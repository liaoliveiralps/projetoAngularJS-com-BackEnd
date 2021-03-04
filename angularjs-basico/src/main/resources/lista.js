angular.module("listaTelefonica", ["ngMessages"]);
angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, $http){
        $scope.app = "Lista Telefônica";
        
        $scope.contatos = [];

        $scope.operadoras = [];

		var carregarContatos = function () {
			$http({
				method: 'GET',
				url: 'http://localhost:9999/contato'
			}).then(function sucessCallBack(response){
				$scope.contatos = response.data;
			}, function errorCallback(response){
                alert("Ocorreu um erro")
            });
		};

        var carregarOperadoras = function () {
            $http({
                method: 'GET',
                url: 'http://localhost:9999/operadora'
            }).then(function sucessCallBack(response){
                $scope.operadoras = response.data;
            }, function errorCallback(response){
                alert("Ocorreu um erro")
            });
        };

        $scope.adicionarContato = function (contato) {
            contato.data = new Date();
            $http({
                method: 'POST',
                url: 'http://localhost:9999/contato'
            }).then(function sucessCallBack(response){
                $
            })//terminar
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
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