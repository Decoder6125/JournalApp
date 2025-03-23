package net.engineeringdigest.journalApp.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection="journal_entry_new")
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;


}
