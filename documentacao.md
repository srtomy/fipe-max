### max-fipe

web service para atualizar e baixar a ultima versão da tabela FIPE, disponibilizar a tabela baixada sem restrição de acesso seguindo o mesmo padrão.

* urls:

  localhost:8080/ws/marcas = retora todas as marcas que um veiculo possui na tabela fipe

  localhost:8080/ws/{marca}/ = retora todas os modelos que um veiculo possui na tabela fipe

  localhost:8080/ws/{marca}/{modelo} = retorna todos os anos que o modelo possui

  localhost:8080/ws/{marca}/{modelo}/{ano} = obtem o valor do veiculo

{marca} = identificação da Marca (int)
{modelo} = identificação do modelo (int)
{ano} = identificação do ano (int) 



