package org.example.service;

import org.example.entity.Operation;
import org.example.storage.OperationStorage;
import org.springframework.stereotype.Component;

@Component
public class OperationService {
    private final OperationStorage operationStorage;
    private final Operation operation;


    public OperationService(OperationStorage operationStorage, Operation operation) {
        this.operationStorage = operationStorage;
        this.operation = operation;
    }

    public void saveOperation(double num1, double num2, double result, int id, String operator) {
        operationStorage.addOperationToStorage(operation.createOperation(num1, num2, result, id, operator));
    }

    public void getOperation(int id) {
        operationStorage.getOperationInStorage(id);
    }

    public void deleteUserOperations(int id) {
        operationStorage.clearOperationStorage(id);
    }
}