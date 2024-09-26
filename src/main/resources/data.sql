INSERT INTO Televisions
(brand, name, price, available_size, refresh_rate, screen_type, screen_quality,
 smarttv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold,
 sold_date)
VALUES ('Samsung', 'Samsung Crystal UHD', 799.99, 2, 2, 0, 2, true, true, true,
        true, true, false, 150, 20, '2024-09-11'),
       ('LG', 'LG OLED C1', 1499.99, 3, 3, 1, 3, true, true, true, true, true,
        true, 100, 15, '2024-09-10'),
       ('Samsung', 'Samsung QLED Q80A', 999.99, 2, 2, 2, 2, true, true, true,
        true, true, true, 120, 25, '2024-09-09'),
       ('Sony', 'Sony Bravia X90J', 1299.99, 3, 3, 0, 2, true, true, true, true,
        true, true, 200, 50, '2024-09-08'),
       ('LEDPhilips', 'Philips Ambilight OLED', 1799.99, 2, 1, 1, 3, true, true,
        true, true, true, true, 80, 10, '2024-09-07');


INSERT INTO Remotes (compatible_With, battery_type, brand, price,
                     original_stock)
VALUES ('Television Model X123', 'AA', 'Banaan', 19.99, 50);


INSERT INTO CImodules (name, type, price)
VALUES ('CI Module A1', 'Basic', 29.99),
       ('CI Module B2', 'Advanced', 49.99),
       ('CI Module C3', 'Premium', 69.99),
       ('CI Module D4', 'Ultra', 89.99),
       ('CI Module E5', 'Standard', 39.99);
