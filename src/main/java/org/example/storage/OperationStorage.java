package org.example.storage;

import org.example.console.ConsoleWriter;
import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationStorage {
    private final ConsoleWriter consoleWriter;

    public OperationStorage(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    private final List<Operation> operationsList = new ArrayList<>();

    public boolean addOperationToStorage(Operation operation) {
        return operationsList.add(operation);
    }

    public void clearOperationStorage(int id) {
        operationsList.removeIf(result -> result.getId() == id);
    }

    public void getOperationInStorage(int id) {
        for (Operation result : operationsList) {
            if (result.getId() == id) {
                consoleWriter.toReport(result + "\n");
            }
        }
    }
}



