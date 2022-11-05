# Trabajo Práctico MyBank - Grupo 5

## TDAs

- AdministradorColasTDA

- ColaTPTDA

___
## Administrador de Colas

- Inicializar: cantidadPuestos (int)
    - Crea una ColaTPTDA por "cantidadPuestos".
        - Inicializa la ColaTPTDA
            - Si cantidadPuestos >= 4 && se crearon  menos de 4 puestos:
                - Asignar "tipoPuesto" a partir de diccionario "clasificaciones".
            - Si no, asignar tipoPuesto en "X"
    - Agrega la ColaTPTDA al diccionario "puestos"

#

- AgregarCola: ?

#

- CantidadDeColas: devuelve "cantidadPuestos"

#

- DevolverCola: idCola (int)

#

- TiempoEstimadoCola: idCola (int)
    - Devuelve el tiempo total de la cola con "idCola"

#

- PuestoDelElemento: turno (Turno)

#

- Detalles del TDA:
    - El diccionario "puestos" está compuesto por: clave = idCola, valor = ColaTPTDA
    - Cada cola es a un tipo de puesto (String). La clasificación se encuentra en la propiedad "tipoPuesto" y son:
        - C: clientes
        - P: no clientes
        - J: jubilados
        - S: servicios
        - X: general
    
    - "Clasificaciones" es un diccionario clave = indice, valor = clasificación. Ver valores en "tipoPuesto".

    - "Turno" es un TDA con las siguientes propiedades y métodos:
        - Nomenclatura (String): ejemplo, "J1" representa Jubilado, id 1.
        - id (int): identificador único.
        - idCola (int): id de la cola a la que el ticket está asociado.
        - tiempoAtencion (int): el tiempo de espera asociado al turno

        - Inicializar (nomenclatura, id, idCola): asigna las variables parámetro a sus propiedades correspondientes.

___

## ColaTPTDA

- tiempoTotal (int)

- Inicializar: inicializa la estructura
- AcolarPrioridad: turno (Turno)
    - Si no existe el "id" del "turno" en "conjuntoIds":
        - Agregar el "turno" a la cola y sumar el "turno"."tiempoAtencion" al "tiempoTotal". 

- Desacolar: 
    - Desacola el elemento con mayor prioridad. Resta de "tiempoTotal" el "turno"."tiempoAtencion", donde "turno" es el elemento desacolado.

- Primero: devuelve el primer turno de la cola.

- DevolverTiempoTotal: devuelve "tiempoTotal"

- ColaVacia: devuelve si la cola está o no vacía.

___

