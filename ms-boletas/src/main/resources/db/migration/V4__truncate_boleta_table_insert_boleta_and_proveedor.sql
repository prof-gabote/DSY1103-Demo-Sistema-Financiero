TRUNCATE TABLE bd_boletas.boleta RESTART IDENTITY;

INSERT INTO bd_boletas.proveedor (id, rut, nombre, direccion, telefono) VALUES
(100, '12345678-9', 'Proveedor A', 'Calle 123', '123456789'),
(101, '98765432-1', 'Proveedor B', 'Avenida 456', '987654321'),
(102, '55555555-5', 'Proveedor C', 'Calle 789', '555555555'),
(103, '11111111-1', 'Proveedor D', 'Avenida 321', '111111111'),
(104, '22222222-2', 'Proveedor E', 'Calle 654', '222222222'),
(105, '33333333-3', 'Proveedor F', 'Avenida 987', '333333333');

INSERT INTO bd_boletas.boleta (folio, glosa, tipo, fecha_emision, monto_bruto, monto_neto, estado, id_proveedor) VALUES
('3456', 'Compra de insumos', 'EXENTA', '2024-06-01', 100000, 95000, 'PAGADA', 100),
('7890', 'Venta de productos', 'AFECTA', '2024-06-02', 200000, 190000, 'PENDIENTE', 101),
('1234', 'Servicio de consultoría', 'EXENTA', '2024-06-03', 150000, 140000, 'PAGADA', 102),
('3687', 'Compra de equipo', 'AFECTA', '2024-06-04', 300000, 285000, 'PENDIENTE', 103),
('5678', 'Venta de servicios', 'EXENTA', '2024-06-05', 250000, 240000, 'PAGADA', 104),
('20292', 'Compra de software', 'AFECTA', '2024-06-06', 400000, 380000, 'PENDIENTE', 104),
('9012', 'Compra de materiales', 'AFECTA', '2024-06-06', 120000, 114000, 'PENDIENTE', 105),
('4321', 'Venta de productos', 'EXENTA', '2024-06-07', 180000, 170000, 'PAGADA', 105);