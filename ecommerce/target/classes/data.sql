-- ============================================================
-- SEED DATI — RESET E POPOLAZIONE
-- ============================================================
-- Questo script pulisce il database e inserisce i dati iniziali.
-- Viene eseguito ogni volta che il database viene avviato.

-- Cleanup (ordine basato sulle dipendenze FK: prima i figli, poi i genitori)
DELETE FROM orders;
DELETE FROM products;
DELETE FROM users;

-- ---- USERS -------------------------------------------------
-- Popolamento utenti base
INSERT INTO users (first_name, last_name, email)
SELECT 'Alice', 'Rossi', 'alice.rossi@example.com'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'alice.rossi@example.com');

INSERT INTO users (first_name, last_name, email)
SELECT 'Bob', 'Verdi', 'bob.verdi@example.com'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'bob.verdi@example.com');

INSERT INTO users (first_name, last_name, email)
SELECT 'Carla', 'Bianchi', 'carla.bianchi@example.com'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'carla.bianchi@example.com');

INSERT INTO users (first_name, last_name, email)
SELECT 'Davide', 'Conti', 'davide.conti@example.com'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'davide.conti@example.com');

INSERT INTO users (first_name, last_name, email)
SELECT 'Elena', 'Ferrari', 'elena.ferrari@example.com'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'elena.ferrari@example.com');

-- ---- PRODUCTS ------------------------------------
-- price DECIMAL(10,2); available BOOLEAN; brand VARCHAR (null ammessa)
INSERT INTO products (name, description, price, available, brand)
SELECT 'Smartphone Aurora', '4G 128GB, 5000mAh', 399.00, true, 'SAMSUNG'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartphone Aurora');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Laptop SlimBook', '14", 16GB RAM', 650.00, true, 'APPLE'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Laptop SlimBook');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Tablet Xpress', '10.1", WiFi+LTE', 289.50, true, 'XIAOMI'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Tablet Xpress');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Earbuds Pulse', 'ANC, 30h di batteria', 79.90, true, 'HONOR'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Earbuds Pulse');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Charger RapidVolt 65W', 'GaN USB-C', 45.00, true, NULL
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Charger RapidVolt 65W');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Kit Lenti Tele 12-60mm', 'Per mirrorless', 399.99, false, NULL
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Kit Lenti Tele 12-60mm');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Smartwatch Pulse S', '41mm, GPS dual-band', 199.00, true, 'HONOR'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartwatch Pulse S');

INSERT INTO products (name, description, price, available, brand)
SELECT 'Smartphone Nova 5G', '256GB, Snapdragon', 899.00, false, 'XIAOMI'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartphone Nova 5G');

-- ---- ORDERS ------------------------------------
-- RELAZIONE: 1 Product -> 1 Order (mappata in Product.java come OneToOne)
-- Vincolo: ogni prodotto può appartenere ad al massimo un ordine.
-- FK: user_id (N→1) e product_id (1→1)
-- Totale sempre price * quantity.

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 2, 798.00, NOW(), 'PENDING'
from users u JOIN products p ON u.email = 'alice.rossi@example.com' AND p.name = 'Smartphone Aurora'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 1, 650.00, NOW(), 'PENDING'
from users u JOIN products p ON u.email = 'bob.verdi@example.com' AND p.name = 'Laptop SlimBook'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 3, 868.50, NOW(), 'SHIPPED'
from users u JOIN products p ON u.email = 'carla.bianchi@example.com' AND p.name = 'Tablet Xpress'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 2, 159.80, NOW(), 'DELIVERED'
from users u JOIN products p ON u.email = 'davide.conti@example.com' AND p.name = 'Earbuds Pulse'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 1, 45.00, NOW(), 'PENDING'
from users u JOIN products p ON u.email = 'elena.ferrari@example.com' AND p.name = 'Charger RapidVolt 65W'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);

INSERT INTO orders (user_id, product_id, quantity, total_price, order_date, status)
SELECT u.id, p.id, 1, 199.00, NOW(), 'CANCELLED'
from users u JOIN products p ON u.email = 'alice.rossi@example.com' AND p.name = 'Smartwatch Pulse S'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE user_id = u.id AND product_id = p.id);
