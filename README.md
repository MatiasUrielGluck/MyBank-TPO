# Trabajo Práctico MyBank - Grupo 5

## TDAs

- AdministradorColasTDA

- ColaTPTDA

## Administrador de Colas

- Inicializar: cantidadPuestos (int)
    - Crea una ColaTPTDA por "cantidadPuestos".
        - Inicializa la ColaTPTDA
            - Si cantidadPuestos >= 4 && se crearon  menos de 4 puestos:
                - Asignar "tipoPuesto" a partir de diccionario "clasificaciones".
            - Si no, asignar tipoPuesto en "X"
    - Agrega la ColaTPTDA al diccionario "puestos"

___

- AgregarCola: 

___

- Detalles del TDA:
    - El diccionario "puestos" está compuesto por: clave = idCola, valor = ColaTPTDA
    - Cada cola es a un tipo de puesto (String). La clasificación se encuentra en la propiedad "tipoPuesto" y son:
        - C: clientes
        - P: no clientes
        - J: jubilados
        - S: servicios
        - X: general
    
    - "Clasificaciones" es un diccionario clave = indice, valor = clasificación. Ver valores en "tipoPuesto".

    