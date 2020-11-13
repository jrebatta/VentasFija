$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/FlujoRemotoOut.feature");
formatter.feature({
  "line": 1,
  "name": "Flujo de Ventas Fija Remoto Out",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Como Usuario Remoto-Call-In, realizo login en Web Ventas Fijas",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-remoto-call-in,-realizo-login-en-web-ventas-fijas",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Remoto-Abre login en web de venta fija \"\u003cId-VENDEDOR\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Remoto-Ingreso codatis y doy click en continuar \"\u003cId-VENDEDOR\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Remoto-Ingreso password Remoto y Clic en iniciar sesion \"\u003cId-VENDEDOR\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-remoto-call-in,-realizo-login-en-web-ventas-fijas;",
  "rows": [
    {
      "cells": [
        "Id-VENDEDOR"
      ],
      "line": 9,
      "id": "flujo-de-ventas-fija-remoto-out;como-usuario-remoto-call-in,-realizo-login-en-web-ventas-fijas;;1"
    },
    {
      "cells": [
        "3"
      ],
      "line": 10,
      "id": "flujo-de-ventas-fija-remoto-out;como-usuario-remoto-call-in,-realizo-login-en-web-ventas-fijas;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 573100,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Como Usuario Remoto-Call-In, realizo login en Web Ventas Fijas",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-remoto-call-in,-realizo-login-en-web-ventas-fijas;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Remoto-Abre login en web de venta fija \"3\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Remoto-Ingreso codatis y doy click en continuar \"3\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Remoto-Ingreso password Remoto y Clic en iniciar sesion \"3\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 40
    }
  ],
  "location": "Steps_Remoto.remoto_abriendo_el_navegador(int)"
});
formatter.result({
  "duration": 38453467100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 49
    }
  ],
  "location": "Steps_Remoto.remoto_ingresa_codatis_continuar(int)"
});
formatter.result({
  "duration": 7953065900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 57
    }
  ],
  "location": "Steps_Remoto.remoto_ingresar_pass(int)"
});
formatter.result({
  "duration": 2396063700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Como Usuario Presencial-Tiendas, realizo alta nueva",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-presencial-tiendas,-realizo-alta-nueva",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Remoto Out-Selecciono Operacion Comercial Alta Nueva \"\u003cId-Cliente\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Remoto Out-Seleccionar y evaluar tipo de documento \"\u003cId-Cliente\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Remoto Out-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación \"\u003cId-Cliente\u003e\", clic en Evaluar y clic en Continuar",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Remoto Out-Ingreso de direccion y referencia \"\u003cId-Cliente\u003e\", ubicar en mapa y Continuar",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Remoto Out-Selecciono la campania \"\u003cId-Cliente\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Remoto Out-Selecciono el producto del \"\u003cId-Cliente\u003e\" a contratar Alta",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Remoto Out-Acepto las condiciones de venta, resumen de venta y contrato Alta \"\u003cId-Cliente\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Remoto Out-Valido la identidad del cliente \"\u003cId-Cliente\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Remoto Out-Acepto resumen de venta, contrato Alta, Agrego numero de contacto, cierro la venta de Alta e Ir al Menú \"\u003cId-Cliente\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Remoto Out-Valido y Cargo el audio del \"\u003cId-Cliente\u003e\" y obtengo mensaje exitoso",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-presencial-tiendas,-realizo-alta-nueva;",
  "rows": [
    {
      "cells": [
        "Id-Cliente"
      ],
      "line": 28,
      "id": "flujo-de-ventas-fija-remoto-out;como-usuario-presencial-tiendas,-realizo-alta-nueva;;1"
    },
    {
      "cells": [
        "11"
      ],
      "line": 29,
      "id": "flujo-de-ventas-fija-remoto-out;como-usuario-presencial-tiendas,-realizo-alta-nueva;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 246400,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Como Usuario Presencial-Tiendas, realizo alta nueva",
  "description": "",
  "id": "flujo-de-ventas-fija-remoto-out;como-usuario-presencial-tiendas,-realizo-alta-nueva;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Remoto Out-Selecciono Operacion Comercial Alta Nueva \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Remoto Out-Seleccionar y evaluar tipo de documento \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Remoto Out-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación \"11\", clic en Evaluar y clic en Continuar",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Remoto Out-Ingreso de direccion y referencia \"11\", ubicar en mapa y Continuar",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Remoto Out-Selecciono la campania \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Remoto Out-Selecciono el producto del \"11\" a contratar Alta",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Remoto Out-Acepto las condiciones de venta, resumen de venta y contrato Alta \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Remoto Out-Valido la identidad del cliente \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Remoto Out-Acepto resumen de venta, contrato Alta, Agrego numero de contacto, cierro la venta de Alta e Ir al Menú \"11\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Remoto Out-Valido y Cargo el audio del \"11\" y obtengo mensaje exitoso",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 54
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutSeleccionoOperacionComercialAltaNueva(int)"
});
formatter.result({
  "duration": 23200330000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 52
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutSeleccionarYEvaluarTipoDeDocumento(int)"
});
formatter.result({
  "duration": 19908668900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 116
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutSeleccionarTipoDeDocIngresarDocumentoIngresarDepartamentoProvinciaYDistritoDeInstalaciónClicEnEvaluarYClicEnContinuar(int)"
});
formatter.result({
  "duration": 27194620800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 46
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutIngresoDeDireccionYReferenciaUbicarEnMapaYContinuar(int)"
});
formatter.result({
  "duration": 11487652600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 35
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutSeleccionoLaCampania(int)"
});
formatter.result({
  "duration": 9484118100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 39
    }
  ],
  "location": "Steps_Remoto_Out.remotoOutSeleccionoElProductoDelAContratarAlta(int)"
});
