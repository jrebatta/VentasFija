Feature: Flujo de Ventas Fija Presencial

  @SmokeTest
  Scenario Outline: Como Usuario Presencial-Tiendas, realizo login en Web Ventas Fijas
    Given Presencial-Abre login en web de venta fija "<Id-VENDEDOR>"
	When  Presencial-Ingreso codatis y doy clic en continuar "<Id-VENDEDOR>"
	And   Presencial-Obtengo token "<Id-VENDEDOR>"
	Then  Presencial-Ingreso password y token, Clic en iniciar sesion "<Id-VENDEDOR>"
	Examples:
       | Id-VENDEDOR|
       | 1 |

  @SmokeTest
  Scenario Outline: Como Usuario Presencial-Tiendas, realizo alta nueva
    Given Presencial-Selecciono Operacion Comercial Alta Nueva "<Id-Cliente>"
    And   Presencial-Ingreso datos del cliente "<Id-Cliente>", fijo el lugar de instalacion y doy click en Continuar
    And   Presencial-Selecciono la campania "<Id-Cliente>"
    And   Presencial-Selecciono el producto del "<Id-Cliente>" a contratar Alta
    When  Presencial-Acepto las condiciones de venta, resumen de venta y contrato Alta "<Id-Cliente>"
    And   Presencial-Valido la identidad del cliente Alta "<Id-Cliente>"
    Then  Presencial-Agrego numero de contacto, cierro la venta de Alta e Ir al Menú "<Id-Cliente>"
    Examples:
       | Id-Cliente|
       | 1 |

  @SmokeTest
  Scenario Outline: Como Usuario Presencial-Tiendas, realizo una migracion
    Given Presencial-Selecciono Operacion Comercial Migraciones "<Id-Cliente>"
    And   Presencial-Ingreso datos del cliente a migrar "<Id-Cliente>"
    And   Presencial-Selecciono producto del "<Id-Cliente>" a migrar
    When  Presencial-Acepto las condiciones, resumen de venta y contrato Migraciones "<Id-Cliente>"
    And   Presencial-Hago la validacion de reniec "<Id-Cliente>"
    Then  Presencial-Agrego numero de contacto, cierro la venta de Migracion e Ir al Menú "<Id-Cliente>"
    Examples:
      | Id-Cliente|
      | 5 |

  @SmokeTest
  Scenario Outline: Como Usuario Presencial-Tiendas, realizo un SVA
    Given Presencial-Selecciono Operacion Comercial SVA "<Id-Cliente>"
    And   Presencial-Ingreso datos del cliente que contratara SVA "<Id-Cliente>"
    And   Presencial-Selecciono producto al que se sumara SVAs "<Id-Cliente>"
    And   Presencial-Selecciono SVA del "<Id-Cliente>"
    When  Presencial-Acepto las condiciones de venta, resumen de venta y contrato SVA "<Id-Cliente>"
    And   Presencial-Valido la identidad del cliente SVA "<Id-Cliente>"
    Then  Presencial-Agrego numero de contacto, cierro la venta de SVA e Ir al Menú "<Id-Cliente>"
    Examples:
      | Id-Cliente|
      | 9 |

