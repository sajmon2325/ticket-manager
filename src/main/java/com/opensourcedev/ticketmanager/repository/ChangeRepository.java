package com.opensourcedev.ticketmanager.repository;

import com.opensourcedev.ticketmanager.model.items.Change;
import org.springframework.data.repository.CrudRepository;

public interface ChangeRepository extends CrudRepository<Change, String> {
}
