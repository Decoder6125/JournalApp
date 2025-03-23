package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Repositories.MongoRepo;
import net.engineeringdigest.journalApp.entities.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryServices {

   @Autowired private MongoRepo mongoRepo;

    public void saveEntry(JournalEntry journalEntry) {
        mongoRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return mongoRepo.findAll();

    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return mongoRepo.findById(id);
    }

    public boolean deleteEntries(ObjectId id) {
        mongoRepo.deleteById(id);
        return true;
    }
}
