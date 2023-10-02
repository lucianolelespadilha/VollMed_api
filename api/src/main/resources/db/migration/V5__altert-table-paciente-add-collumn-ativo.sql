/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  llpad
 * Created: 2 de out. de 2023
 */

alter table pacientes add ativo tinyint ;

update pacientes set ativo = 1;