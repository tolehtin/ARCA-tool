-- Add rcacase column to cause-table.

ALTER TABLE cause ADD COLUMN rcacase_id BIGINT UNSIGNED NOT NULL;

ALTER TABLE cause ADD CONSTRAINT FOREIGN KEY (rcacase_id) REFERENCES rcacase(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE wircatestuser.usercases MODIFY case_id BIGINT UNSIGNED NOT NULL;
