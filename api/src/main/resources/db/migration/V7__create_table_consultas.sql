/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  llpad
 * Created: 10 de dez. de 2023
 */
 create table consultas(
        id  bigint not null auto_increment,
        medico_id  bigint not null,
        paciente_id  bigint not null,
        data datetime  not null,

primary key(id),
constraint fk_consultas_medico_id  foreign key(medico_id)   references medicos(id),
constraint fk_consultas_pacientes_id foreign key(paciente_id) references pacientes(id)
);
