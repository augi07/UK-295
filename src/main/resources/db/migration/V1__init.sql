-- Erstellt die User Tabelle
CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
    );

-- Erstellt die User-Rollen Tabelle
CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id BIGINT NOT NULL,
                                          role VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
    );

-- Erstellt die Kategorie Tabelle
CREATE TABLE IF NOT EXISTS category (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );

-- Erstellt die Produkt Tabelle
CREATE TABLE IF NOT EXISTS product (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
    );

-- Admin Benutzer einfügen (Passwort = "admin123" bcrypt-hash)
INSERT INTO user (email, password) VALUES
    ('admin@example.com', '$2a$10$Rk0OpjUXPeCxoLVA9r0UMeqtd0CUIlYQqTtrR62yM75y6PYVR85Q2'); -- admin123

INSERT INTO user_roles (user_id, role) VALUES
    (1, 'ADMIN');
