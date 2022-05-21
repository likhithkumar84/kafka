CREATE TABLE IF NOT EXISTS patient_enroll
(
    id_e                 SERIAL      PRIMARY KEY,
    patient_id           VARCHAR(50) NOT NULL,
    created_at           TIMESTAMP   NOT NULL,
    tenant_id            VARCHAR(50),
    protocol_id          VARCHAR(50) NOT NULL,
    protocol_instance_id VARCHAR(50) NOT NULL,
    active               VARCHAR(10) NOT NULL,
    deleted              VARCHAR(10) NOT NULL,
    created_by           VARCHAR(50),
    updated_by           VARCHAR(50),
    updated_at           TIMESTAMP
);


