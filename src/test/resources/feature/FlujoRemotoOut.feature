Feature: Flujo de Ventas Fija Remoto Out

  @SmokeTest
  Scenario Outline: Como Usuario Remoto-Call-In, realizo login en Web Ventas Fijas
    Given Remoto-Abre login en web de venta fija "<Id-VENDEDOR>"
    When  Remoto-Ingreso codatis y doy click en continuar "<Id-VENDEDOR>"
    Then  Remoto-Ingreso password Remoto y Clic en iniciar sesion "<Id-VENDEDOR>"
    Examples:
      | Id-VENDEDOR|
      |  3 |

    @SmokeTest
   Scenario Outline: Como Usuario Presencial-Tiendas, realizo alta nueva
    Given Remoto Out-Selecciono Operacion Comercial Alta Nueva "<Id-Cliente>"
    And   Remoto Out-Seleccionar y evaluar tipo de documento "<Id-Cliente>"
    And   Remoto Out-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación "<Id-Cliente>", clic en Evaluar y clic en Continuar
    And   Remoto Out-Ingreso de direccion y referencia "<Id-Cliente>", ubicar en mapa y Continuar
    And   Remoto Out-Selecciono la campania "<Id-Cliente>"
    And   Remoto Out-Selecciono el producto del "<Id-Cliente>" a contratar Alta
    When  Remoto Out-Acepto las condiciones de venta, resumen de venta y contrato Alta "<Id-Cliente>"
    And   Remoto Out-Valido la identidad del cliente "<Id-Cliente>"
    And   Remoto Out-Acepto resumen de venta, contrato Alta, Agrego numero de contacto, cierro la venta de Alta e Ir al Menú "<Id-Cliente>"
    Then  Remoto Out-Valido y Cargo el audio del "<Id-Cliente>" y obtengo mensaje exitoso


    Examples:
      | Id-Cliente|
      | 11 |