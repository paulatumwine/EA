<property name="hibernate.id.new_generator_mappings" value="false"/>
- This is a fix to make sure GeneratedValue strategy will use Identity when it sets to AUTO.
- By default, it chose to use Sequence even though MySQL doesn't support for sequence

When use persist() to save
-if use sequence, it won't save right way, it'll get the id from sequence object/table, then wait till a better time to insert like commit, close.

1
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
2
Hibernate: insert into Person (name, id) values (?, ?)
3