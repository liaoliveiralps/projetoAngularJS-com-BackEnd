angular.module("listaTelefonica").factory("contatosAPI", function ($http, config) {
	var _getContatos = function () {
		return $http({
				method: 'GET',
				url: config.baseUrl + '/contato'
			});
	};

	var _getContato = function (id) {
		return $http({
				method: 'GET',
				url: config.baseUrl + '/contato/' + id
			});
	};
	
	var _saveContato = function (contato) {
		return $http({
                method: 'POST',
                url: config.baseUrl + '/contato',
				data: {
					nome: contato.nome,
					telefone: contato.telefone,
					data: contato.data,
					operadora:{
						nome: contato.operadora.nome
					}
				}
            })
	};

	var _deleteContato = function (id) {
		return $http({
			method: 'DELETE',
			url: config.baseUrl + '/contato/' + id
		})
	}
	
	return {
		getContatos: _getContatos,
		getContato: _getContato,
		saveContato: _saveContato,
		deleteContato: _deleteContato
	};
	
})