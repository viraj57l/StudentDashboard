
CREATE TABLE subject (
    id SERIAL PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE student_subjects (
    student_id INTEGER NOT NULL,
    subjects_id INTEGER NOT NULL,
    PRIMARY KEY (student_id, subjects_id),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (subjects_id) REFERENCES subject(id) ON DELETE CASCADE
);