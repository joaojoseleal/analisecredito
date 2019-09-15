angular.module('app', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('app').controller('propostaModalController', function ($uibModal, $log) {
  var pc = this;
  pc.data = "Lorem Name Test";

  pc.open = function (size) {
    var modalInstance = $uibModal.open({
      animation: true,
      ariaLabelledBy: 'modal-title',
      ariaDescribedBy: 'modal-body',
      templateUrl: 'src/proposta/propostaModal.html',
      controller: 'ModalInstanceCtrl',
      controllerAs: 'pc',
      size: size,
      resolve: {
        data: function () {
          return pc.data;
        }
      }
    });

    modalInstance.result.catch(function () {
      window.location.reload();
    });
  };
});


angular.module('app').controller('ModalInstanceCtrl', function ($uibModalInstance, data) {
  var pc = this;
  pc.data = data;

  pc.ok = function () {
    alert("You clicked the ok button.");
    $uibModalInstance.close();
  };

  pc.cancel = function () {
    //{...}
    $uibModalInstance.dismiss('cancel');
  };
});

angular.module('app').controller('propostaController', function ($scope, $http) {
  var urlContext = 'http://localhost:8080/analisecredito/api/';
  var headers = { 'Authorization': 'Basic ' + btoa('@dmin:@dmin') };

  $scope.alerts = [];

  $scope.closeAlert = function (index) {
    $scope.alerts.splice(index, 1);
  };

  $http.get(urlContext + 'proposta', {
    headers: headers
  }).then(function (response) {
    $scope.propostas = response.data;
  });

  $scope.pessoa = {
    cpf: '',
    nome: '',
    idade: 0,
    sexo: '',
    estadoCivilEnum: '',
    estado: '',
    dependentes: 0,
    renda: 0
  }

  $scope.salvar = function () {
    $http.post(urlContext + 'proposta/save',
      JSON.stringify($scope.pessoa),
      { headers: headers }
    ).then(function successCallback(response) {
      $scope.alerts.push({ type: 'success', msg: 'Registro gravado com sucesso.' });
      $scope.formProposta.$setPristine();
      $scope.formProposta.$setUntouched();
      $scope.pessoa = {};
    }, function errorCallback(response) {
      if (response.status == 400) {
        $scope.alerts.push({ type: 'danger', msg: 'Dados inválidos. Verifique e tente novamente.' });
      } else {
        $scope.alerts.push({ type: 'danger', msg: 'Ocorreu um erro no envio dos dados para o servidor. Tente novamente mais tarde.' });
      }
    });
  }

  $scope.converterLimiteEnum = function (limite) {
    switch (limite) {
      case 'REPROVADO_POLITICA':
        return 'REPROVADO PELA POLITICA DE CREDITO';
      case 'RENDA_BAIXA':
        return 'RENDA BAIXA';
      case 'CEM_QUINHENTOS':
        return '100 - 500';
      case 'QUINHENTOS_MIL':
        return '500 - 1000';
      case 'MIL_MILQUINHENTOS':
        return '1000 - 1500';
      case 'MILQUINHENTOS_DOISMIL':
        return '1500 - 2000';
      case 'MAIOR_2000':
        return 'SUPERIOR 2000';
    }
  }
});