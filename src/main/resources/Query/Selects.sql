Query de busca por nome e id_departamento
--select d.nome_departamento, count(t.status_tarefa) total
--from tb_departamento d
--inner join tb_tarefas t
--on d.id_departamento = t.id_departamento
--GROUP BY d.id_departamento, t.id_departamento

Retornar a pessoa que mais gastou horas em janeiro de 2022
--Select Max(tt.duracao) as duracaoTotal, tf.nome, tt.id_funcionario
--from tb_tarefas tt
--inner join tb_funcionario tf
--on tt.id_funcionario = tf.id_funcionario
--where tt.dt_registro between '2022-01-01' AND '2022-01-31'
--group by tf.nome, tt.id_tarefa