package com.example.server.promise.repository;

import com.example.server.promise.Promise;
import com.example.server.promise.dto.PromiseInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PromiseRepository extends JpaRepository<Promise, Long> {

    @Query(value = "SELECT id, date, location, memo, organizer, penalty, title " +
            "FROM Promise " +
            "WHERE id IN ( " +
            "SELECT promise_id FROM PromiseMember WHERE nickname = ?1 AND accepted = 'Y') AND date BETWEEN ?2 AND ?3 "
            , nativeQuery = true)
    List<PromiseInterface> selectPromiseList(String nickname, String start, String end) throws Exception;

    @Query(value = "SELECT id, date, location, memo, organizer, penalty, title " +
            "FROM Promise " +
            "WHERE id IN ( " +
            "SELECT promise_id FROM PromiseMember WHERE nickname = ?1 AND accepted = 'N')"
            , nativeQuery = true)
    List<PromiseInterface> selectPromiseRequestList(String nickname) throws Exception;
}
