/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  llpad
 * Created: 2 de out. de 2023
 */

alter table medicos add ativo tinyint ;

update medicos set ativo = 1;