CREATE INDEX learning_object_idx1 ON learning_object USING btree (name);
CREATE INDEX learning_object_idx2 ON learning_object USING btree (active);
CREATE INDEX skill_idx1 ON skill USING btree (education_year_id);
CREATE INDEX skill_idx2 ON skill USING btree (content_theme_id);
CREATE INDEX descriptor_idx1 ON descriptor USING btree (education_level_id);
CREATE INDEX descriptor_idx2 ON descriptor USING btree (content_theme_id);
CREATE INDEX curriculum_idx1 ON curriculum USING btree (short_name);
CREATE INDEX education_year_idx1 ON education_year USING btree (education_level_id);
