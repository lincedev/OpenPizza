Delimiter $$
create trigger tg_Bebidas
after insert on produto
for each row
begin 
	insert into bebidas (codProduto, preco) values ((select max(codigo) from produto), 1.00);
end$$
Delimiter ;


select max(codigo) from produto;

drop trigger tg_Bebidas;

show triggers;

insert into produto (descricao) values ('ola');

select * from produto;
select * from bebidas;

delete from produto where codigo = 9;
delete from bebidas where codProduto = 9;

alter table bebidas auto_increment = 1;
alter table produto auto_increment = 1;








insert into bebidas (codProduto, preco) values ((select codigo from produto where produto.codigo = (select max(codigo) from produto)), 1.00);






