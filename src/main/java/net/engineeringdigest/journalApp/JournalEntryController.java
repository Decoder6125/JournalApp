package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.entities.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping("journalentries")
@RestController
public class JournalEntryController {

    @Autowired
    JournalEntryServices journalEntries;


@GetMapping
    public List<JournalEntry> getAll() {
    return journalEntries.getAll();
}

@PostMapping
    public boolean postEntries(@RequestBody JournalEntry myEntries) {
    journalEntries.saveEntry(myEntries);
    return true;
}

@GetMapping("/id/{myId}")
    public Optional<JournalEntry> getEntriesById(@PathVariable ObjectId myId) {
    return journalEntries.getById(myId);
}

@DeleteMapping("/id/{myId}")
    public boolean deleteEntriesById(@PathVariable ObjectId myId) {
    return journalEntries.deleteEntries(myId);
    }

@PutMapping("/id/{myId}")
    public JournalEntry updateEntries(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntries){
    JournalEntry old =  journalEntries.getById(myId).orElse(null);
    if(old!=null) {
        old.setTitle(newEntries.getTitle()!=null && !newEntries.getTitle().equals("") ? newEntries.getTitle() : old.getTitle());
        old.setContent(newEntries.getContent()!=null && !newEntries.getContent().equals("") ? newEntries.getContent() : old.getContent());
    }
    journalEntries.saveEntry(old);
    return old;
}


}
