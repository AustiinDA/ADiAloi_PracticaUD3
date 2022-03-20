create table empleado
(
    id         int auto_increment
        primary key,
    id_emp     smallint(4) null,
    apellido   varchar(10) null,
    oficio     varchar(10) null,
    fecha_alta date        null,
    salario    float(6, 2) null,
    comision   float(6, 2) null,
    id_dep     tinyint(2)  null,
    constraint empleado_ibfk_1
        foreign key (id) references departamento (id)
);

