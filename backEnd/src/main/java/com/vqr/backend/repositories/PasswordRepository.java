package com.vqr.backend.repositories;

import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.PasswordModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordRepository extends JpaRepository<PasswordModel, UUID> {
    List<PasswordModel> findAllByEventToBeUsedOrderByPasswordNumberAsc(EventModel eventToBeUsed);
    List<PasswordModel> findAllByEventToBeUsedAndWasItSoldIsFalseOrderByPasswordNumberAsc(EventModel eventToBeUsed);
    List<PasswordModel> findAllByEventToBeUsedAndWasItSoldIsTrueOrderByPasswordNumberAsc(EventModel eventToBeUsed);
}
