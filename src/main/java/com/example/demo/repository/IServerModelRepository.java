package com.example.demo.repository;

import com.example.demo.model.ServerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IServerModelRepository extends MongoRepository<ServerModel, String> {
    Optional<ServerModel> findById(String id);

    List<ServerModel> findAllByName(String name);
}
