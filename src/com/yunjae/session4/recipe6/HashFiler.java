package com.yunjae.session4.recipe6;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class HashFiler implements Runnable {

    private ConcurrentHashMap<String, ConcurrentLinkedDeque<Operation>> userHash;

    public HashFiler(ConcurrentHashMap<String, ConcurrentLinkedDeque<Operation>> userHash) {
        this.userHash = userHash;
    }


    @Override
    public void run() {
        Random radomGenerator = new Random();
        for (int i=0; i<100; i++) {
            Operation operation = new Operation();
            String user = "USER" + radomGenerator.nextInt(100);
            operation.setUser(user);
            String action = "OP" + radomGenerator.nextInt(10);
            operation.setOperation(action);
            operation.setTime(new Date());
            addOperationToHash(userHash, operation);
        }
    }

    private void addOperationToHash(ConcurrentHashMap<String, ConcurrentLinkedDeque<Operation>> userHash, Operation operation) {
        ConcurrentLinkedDeque<Operation> opList = userHash.computeIfAbsent(operation.getUser(),user -> new ConcurrentLinkedDeque<>());
        opList.add(operation);
    }
}
