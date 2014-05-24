SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ProjetoSIN143` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ProjetoSIN143` ;

-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Produto` (
  `codigo` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Pizza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Pizza` (
  `codProduto` INT NOT NULL ,
  `preco` FLOAT NULL ,
  `tamanho` VARCHAR(45) NULL ,
  `fatias` INT NULL ,
  `ingredientes` VARCHAR(300) NULL ,
  `imagem` BLOB NULL ,
  PRIMARY KEY (`codProduto`) ,
  CONSTRAINT `fk_Pizza_Produto`
    FOREIGN KEY (`codProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Lanche`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Lanche` (
  `codProduto` INT NOT NULL ,
  `preco` FLOAT NULL ,
  `ingredientesLanche` VARCHAR(150) NULL ,
  PRIMARY KEY (`codProduto`) ,
  CONSTRAINT `fk_Lanche_Produto1`
    FOREIGN KEY (`codProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Bebidas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Bebidas` (
  `codProduto` INT NOT NULL ,
  `preco` FLOAT NULL ,
  PRIMARY KEY (`codProduto`) ,
  CONSTRAINT `fk_Bebidas_Produto1`
    FOREIGN KEY (`codProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Outros`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Outros` (
  `codProduto` INT NOT NULL ,
  `preco` FLOAT NULL ,
  PRIMARY KEY (`codProduto`) ,
  CONSTRAINT `fk_Outros_Produto1`
    FOREIGN KEY (`codProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Mesa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Mesa` (
  `numero` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`numero`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Pedido`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Pedido` (
  `numeroPedido` INT NOT NULL AUTO_INCREMENT ,
  `numeroMesa` INT UNSIGNED NOT NULL ,
  `data` DATE NULL ,
  `horaInicio` TIME NULL ,
  `horaFim` TIME NULL ,
  `valor` FLOAT NULL DEFAULT 0 ,
  `formaPagamento` VARCHAR(30) NULL ,
  `pedidoFinalizado` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`numeroPedido`, `numeroMesa`) ,
  INDEX `fk_Pedido_Mesa1_idx` (`numeroMesa` ASC) ,
  CONSTRAINT `fk_Pedido_Mesa1`
    FOREIGN KEY (`numeroMesa` )
    REFERENCES `ProjetoSIN143`.`Mesa` (`numero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`Meia_Meia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`Meia_Meia` (
  `codProduto` INT NOT NULL ,
  `precoMini1` FLOAT NULL ,
  `precoMini2` FLOAT NULL ,
  `precoPequena1` FLOAT NULL ,
  `precoPequena2` FLOAT NULL ,
  `precoMedia1` FLOAT NULL ,
  `precoMedia2` FLOAT NULL ,
  `precoGrande1` FLOAT NULL ,
  `precoGrande2` FLOAT NULL ,
  `ingredientesPizza` VARCHAR(250) NULL ,
  `tamanhoPizza` VARCHAR(45) NULL ,
  PRIMARY KEY (`codProduto`) ,
  CONSTRAINT `fk_Meia_Meia_Produto1`
    FOREIGN KEY (`codProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoSIN143`.`ItemDoPedido`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ProjetoSIN143`.`ItemDoPedido` (
  `pedidoNumero` INT NOT NULL ,
  `codigoProduto` INT NOT NULL ,
  `qtdadeProdutos` INT NOT NULL ,
  `tamanho` VARCHAR(45) NULL ,
  `preco` FLOAT NULL ,
  PRIMARY KEY (`pedidoNumero`, `codigoProduto`) ,
  INDEX `fk_Pedido_has_Produto_Produto1_idx` (`codigoProduto` ASC) ,
  INDEX `fk_Pedido_has_Produto_Pedido1_idx` (`pedidoNumero` ASC) ,
  CONSTRAINT `fk_Pedido_has_Produto_Pedido1`
    FOREIGN KEY (`pedidoNumero` )
    REFERENCES `ProjetoSIN143`.`Pedido` (`numeroPedido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Produto_Produto1`
    FOREIGN KEY (`codigoProduto` )
    REFERENCES `ProjetoSIN143`.`Produto` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ProjetoSIN143` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
