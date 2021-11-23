package org.example.storage;

import org.example.entity.Expression;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class OperationsStorage {
    private LinkedList<Expression> operationsList;
    private User user;

    @Autowired
    public OperationsStorage(LinkedList<Expression> operationsList, User user) {
        this.operationsList = operationsList;
        this.user = user;
    }

    public void save(Expression expression) {
        operationsList.add(expression);
    }

    public void clear() {
        operationsList.clear();
    }

    public void get() {
        for (Expression result : operationsList) {
            if (result.getId() == user.getId()) {
                System.out.println(result);
            }
        }
    }
}



