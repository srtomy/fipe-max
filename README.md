fipe-max
=======

web service utilizando o modelo REST para disponibilizar informações de veiculos da tabela FIPE sem restrições. 

Apos baixar a tabela FIPE os dados ficara disponivel em 4 arquivos: marcas.json, modelos.json, valores.json e anos.json esse arquivos deverão ser composto no formato JSON e ao lado do executavel do servidor.

### URLS

* ws/marcas = listar todas as marcas

* ws/{id_marca} = lista todos os modelos da marca

* ws/{id_marca}/{id_modelo} = lista todos os anos que aquele modelo possui

* ws/{id_marca}/{id_modelo}/{id_ano} = lista o valor do veiculo

  {id_marca} = identificação da marca do veiculo
  {id_modelo} = identificação do modelo do veiculo
  {id_ano} = identificação do ano

  Exemplo:

  - http://localhost:8080/marcas: lista todas as marcas.

  ```json
  [
      {
          "name": "AUDI",
          "fipe_name": "Audi",
          "order": 2,
          "key": "audi-6",
          "id": 6
      },
      {
          "name": "BMW",
          "fipe_name": "BMW",
          "order": 2,
          "key": "bmw-7",
          "id": 7
      }
  ]
  ```

  - http://localhost:8080/ws/6: lista todos os modelos da marca "AUDI".

  ```json
    [
        {
            "id_marca": 6,
            "fipe_marca": "Audi",
            "name": "100 2.8 V6",
            "marca": "AUDI",
            "key": "100-43",
            "id": "43",
            "fipe_name": "100 2.8 V6"
        },
        {
            "id_marca": 6,
            "fipe_marca": "Audi",
            "name": "100 2.8 V6 Avant",
            "marca": "AUDI",
            "key": "100-44",
            "id": "44",
            "fipe_name": "100 2.8 V6 Avant"
        }
    ]
  ```

  - http://localhost:8080/ws/6/43: lista todos os anos da marca "Audi" e do modelo "100 2.8 V6"
  
  ```json
    [
        {
            "id_marca": 6,
            "id_modelo": 43,
            "fipe_marca": "Audi",
            "fipe_codigo": "1995-1",
            "name": "1995 Gasolina",
            "marca": "AUDI",
            "key": "1995-1",
            "veiculo": "100 2.8 V6",
            "id": "1995-1"
        },
        {
            "id_marca": 6,
            "id_modelo": 43,
            "fipe_marca": "Audi",
            "fipe_codigo": "1994-1",
            "name": "1994 Gasolina",
            "marca": "AUDI",
            "key": "1994-1",
            "veiculo": "100 2.8 V6",
            "id": "1994-1"
        }
    ]
  ```
  
  - http://localhost:8080/ws/6/43/1995-1: lista o valor da marca "Audi" do modelo "100 2.8 V6" e do ano "1995-1"
  
  ```json
    [
        {
          "id_marca": 6,
            "id_modelo": 44,
            "id_ano": "1995-1",
            "referencia": "setembro de 2019",
            "fipe_codigo": "008076-4",
            "name": "100 2.8 V6 Avant",
            "combustivel": "Gasolina",
            "marca": "Audi",
            "ano_modelo": "1995",
            "preco": "R$ 14.829,00",
            "key": "100-1995",
            "time": 0.0,
            "veiculo": "100 2.8 V6 Avant",
            "id": "1995"
        }
    ]
  ```
  
    



Caracteristicas:
-------------

- Baixar tabela FIPE manualmente
- Baixar tabela FIPE automaticamente
- Disponibilizar Modelos de Veiculos
- Disponibilizar Marcas de Veiculos
- Disponibilizar Anos de Veiculos
- Disponibilizar Valores de Veiculos

Dependencias:
-------------------

- Spring Boot 2.1.7
- Spring Boot Starter Web
- Java 8




