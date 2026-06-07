-- 初始病患資料（3 位虛構病患）
INSERT OR IGNORE INTO patient (chart_no, name, gender, birth_date, phone) VALUES
    ('TEST00001', '測試病患甲', '男', '1985-03-15', '0912-345-678'),
    ('TEST00002', '王小明',     '男', '1990-07-22', '0923-456-789'),
    ('TEST00003', '李小華',     '女', '1988-11-30', '0934-567-890');

-- 統一移除了舊的欄位指定，改用純數值寫法，讓 SQLite 乖乖對齊順序
INSERT OR IGNORE INTO appointment VALUES (1, '2026-05-01', 'BOOKED', 'AM', 'D001', 'TEST00001');
INSERT OR IGNORE INTO appointment VALUES (2, '2026-05-01', 'BOOKED', 'AM', 'D002', 'TEST00002');
INSERT OR IGNORE INTO appointment VALUES (3, '2026-05-02', 'BOOKED', 'PM', 'D003', 'TEST00003');

-- 這是我們後來加的測試資料（一樣用純數值）
INSERT OR IGNORE INTO appointment VALUES (4, '2026-05-20', 'BOOKED', 'AM', 'D001', 'TEST00001');
INSERT OR IGNORE INTO appointment VALUES (5, '2026-05-20', 'BOOKED', 'PM', 'D002', 'TEST00001');
INSERT OR IGNORE INTO appointment VALUES (6, '2026-05-21', 'BOOKED', 'AM', 'D001', 'TEST00001');

-- 初始醫師資料（5 位）帶入 pass1234 的 BCrypt 雜湊
INSERT OR IGNORE INTO doctor (doctor_id, name, department, specialty, password_hash) VALUES
    ('D001', '陳志明醫師', '家醫科', '一般內科、慢性病管理','$2a$10$XhyEgd4qh5TXJa7NkMg3gOqsJxATykAyJERH7ZqTD7eEPVlcmgewm'),
    ('D002', '林佩君醫師', '內科',   '心臟血管、高血壓', '$2a$10$/x/fVm66HZJWeeYZRUbPp..gS9Czgs3a27RjYQPs75obpRoUWU9ZC'),
    ('D003', '王建華醫師', '復健科', '運動傷害、脊椎復健', '$2a$10$4fZBPZq1NJmqW5MUgOUsqukV6OiTJutAKR/WbiFiQ6PRTjFbNsMFy'),
    ('D004', '李美玲醫師', '小兒科', '兒童感冒、疫苗接種',  '$2a$10$ZlsUgEo2MOm0RYxwcP55qukrjipEXYNKyyRfdIKkOEv7RpuXEPhxK'),
    ('D005', '張雅筑醫師', '身心科', '焦慮、失眠、情緒調適', '$2a$10$XsgY9Cmk7PqJ2pve2k4xwuTnV/hakC6LOGJqicQyjH.wDiM7PQhWa');