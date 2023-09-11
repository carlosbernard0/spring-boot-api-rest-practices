alter table medicos add ativo tinyint;
update vollmed_api.medicos set ativo = 1;
