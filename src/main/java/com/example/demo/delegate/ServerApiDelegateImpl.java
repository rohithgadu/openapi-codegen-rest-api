package com.example.demo.delegate;

import com.example.demo.ServerApiDelegate;
import com.example.demo.error.ServerModelNotFoundException;
import com.example.demo.model.ServerModel;
import com.example.demo.repository.IServerModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerApiDelegateImpl implements ServerApiDelegate {

    @Autowired
    IServerModelRepository serverModelRepository;

    @Override
    public ResponseEntity<ServerModel> addServerObject(ServerModel body) {
        ServerModel serverModel = serverModelRepository.save(body);
        return new ResponseEntity<>(serverModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteServerObject(String id) throws ServerModelNotFoundException {
        Optional<ServerModel> ServerModel;
        ServerModel = serverModelRepository.findById(id);
        if (ServerModel.isEmpty()) {
            throw new ServerModelNotFoundException("Unable to delete record, Server Object Not Found by the given id", HttpStatus.NOT_FOUND.value());
        }
        serverModelRepository.deleteById(id);
        return new ResponseEntity<>("Record Successfully Deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ServerModel>> getAllServerObjects() {
        return new ResponseEntity<>(serverModelRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServerModel> getServerObjectById(String id) throws ServerModelNotFoundException {
        Optional<ServerModel> ServerModel;
        ServerModel = serverModelRepository.findById(id);
        if (ServerModel.isEmpty()) {
            throw new ServerModelNotFoundException("Server Object Not Found by the given id", HttpStatus.NOT_FOUND.value());
        }
        return new ResponseEntity<>(ServerModel.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ServerModel>> getServerObjectByName(String name) throws ServerModelNotFoundException {
        List<ServerModel> ServerModelList;
        ServerModelList = serverModelRepository.findAllByName(name);
        if (ServerModelList.isEmpty()) {
            throw new ServerModelNotFoundException("Server Object Not Found by the given name", HttpStatus.NOT_FOUND.value());
        }
        return new ResponseEntity<>(ServerModelList, HttpStatus.OK);
    }


}
