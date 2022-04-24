CREATE INDEX learning_object_idx1 ON learning_object USING btree (name);
CREATE INDEX learning_object_idx2 ON learning_object USING btree (active);
CREATE INDEX learning_object_idx3 ON learning_object USING btree (view_type);
CREATE INDEX skill_idx1 ON skill USING btree (education_level_id);
CREATE INDEX skill_idx2 ON skill USING btree (content_theme_id);
CREATE INDEX descriptor_idx1 ON descriptor USING btree (education_level_id);
CREATE INDEX descriptor_idx2 ON descriptor USING btree (content_theme_id);
CREATE INDEX curriculum_idx1 ON curriculum USING btree (short_name);

