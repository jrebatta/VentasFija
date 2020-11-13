Feature: Flujo de Ventas Fija Remoto

  @SmokeTest
  Scenario Outline: Como Usuario Remoto-Call-In, realizo login en Web Ventas Fijas
    Given Remoto-Abre login en web de venta fija "<Id-VENDEDOR>"
    When  Remoto-Ingreso codatis y doy click en continuar "<Id-VENDEDOR>"
    Then  Remoto-Ingreso password Remoto y Clic en iniciar sesion "<Id-VENDEDOR>"
    Examples:
      | Id-VENDEDOR|
      |  2 |

  @SmokeTest
  Scenario Outline: Como Usuario Remoto-Call-In, realizo alta fija nueva
    Given Remoto-Selecciono Alta Nueva Flujo Remoto "<Id-Cliente>"
    And   Remoto-Ingresar celular del cliente "<Id-Cliente>", clic en Registrar Celular y clic en Continuar
    And   Remoto-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación "<Id-Cliente>", clic en Evaluar y clic en Continuar
    And   Remoto-Valido la identidad del cliente "<Id-Cliente>"
    And   Remoto-Ingreso de direccion y referencia "<Id-Cliente>", ubicar en mapa y Continuar
    And   Remoto-Selecciono la campania "<Id-Cliente>"
    And   Remoto-Selecciono el producto del "<Id-Cliente>" a contratar Alta
    When  Remoto-Acepto las condiciones de venta, resumen de venta y contrato Alta "<Id-Cliente>"
    Then  Remoto-Agrego numero de contacto, cierro la venta de Alta e Ir al Menú "<Id-Cliente>"
    Then  Remoto-Cargo el audio del "<Id-Cliente>" y obtengo mensaje exitoso
    Examples:
      | Id-Cliente|
      |  1 |
      |  2 |
      |  3 |

  @SmokeTest
  Scenario Outline: Como Usuario Remoto-Call-In, realizo una migracion
    Given Remoto-Selecciono Operacion Comercial Migraciones "<Id-Cliente>"
    When  Remoto-Ingresar celular del cliente "<Id-Cliente>", clic en Registrar Celular y clic en Continuar
    And   Remoto-Ingreso datos del cliente a migrar "<Id-Cliente>"
    And   Remoto-Selecciono producto del "<Id-Cliente>" a migrar
    And   Remoto-Acepto las condiciones y Hago la validacion de reniec "<Id-Cliente>"
    And   Remoto-Resumen de venta y contrato de migraciones "<Id-Cliente>"
    Then  Remoto-Agrego numero de contacto, cierro la venta de Migracion e Ir al Menú "<Id-Cliente>"
    Examples:
      | Id-Cliente|
      | 6 |
      | 5 |



  @SmokeTest
  Scenario Outline: Como Usuario Remoto-Call-In, realizo un SVA
    Given Remoto-Selecciono Operacion Comercial SVA "<Id-Cliente>"
    And   Remoto-Ingresar celular del cliente "<Id-Cliente>", clic en Registrar Celular y clic en Continuar
    And   Remoto-Ingreso datos del cliente que contratara SVA "<Id-Cliente>"
    And   Remoto-Selecciono producto al que se sumara SVAs "<Id-Cliente>"
    And   Remoto-Selecciono SVA del "<Id-Cliente>"
    When  Remoto-Acepto las condiciones de venta, resumen de venta y contrato SVA "<Id-Cliente>"
    And   Remoto-Valido la identidad del clientes "<Id-Cliente>"
    Then  Remoto-Agrego numero de contacto, cierro la venta de SVA e Ir al Menú "<Id-Cliente>"
    Examples:
      | Id-Cliente|
      | 9 |