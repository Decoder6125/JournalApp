package net.engineeringdigest.journalApp.Repositories;

import net.engineeringdigest.journalApp.entities.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<JournalEntry, ObjectId> {
}
