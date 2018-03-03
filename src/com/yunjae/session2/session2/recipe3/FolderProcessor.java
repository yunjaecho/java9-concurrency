package com.yunjae.session2.session2.recipe3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountedCompleter;

public class FolderProcessor extends CountedCompleter<List<String>> {
    private String path;

    private String extension;

    private List<FolderProcessor> tasks;
    private List<String> resultList;

    public FolderProcessor(CountedCompleter<?> completer, String path, String extension) {
        super(completer);
        this.path = path;
        this.extension = extension;
    }

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    public void compute() {
        resultList = new ArrayList<>();
        tasks = new ArrayList<>();

        File file = new File(path);
        File[] content = file.listFiles();

        if (content != null) {
            for (int i=0; i<content.length; i++) {
                if (content[i].isDirectory()) {
                    // If is a directory, process it, Execute a new Task
                    FolderProcessor task = new FolderProcessor(this, content[i].getAbsolutePath(), extension);
                    // The new create folderprocess execute Asynchronous
                    task.fork();
                    addToPendingCount(1);
                    tasks.add(task);
                } else {
                    // If is a file, process it, Compare the extension of the file and the extension
                    // It's looking for
                    if (checkFile(content[i].getName())) {
                        resultList.add(content[i].getAbsolutePath());
                        //System.out.printf("result found %s\n", content[i].getAbsoluteFile());
                    }
                }
            }

            if (tasks.size() > 50) {
                System.out.printf("%s: %d tasks ran\n", file.getAbsoluteFile(), tasks.size());
            }
        }

        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        for(FolderProcessor childTask: tasks) {
            resultList.addAll(childTask.getResultList());
        }
    }

    private boolean checkFile(String name) {
        if (name.endsWith(extension)) {
            return true;
        } else {
            return false;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<FolderProcessor> getTasks() {
        return tasks;
    }

    public void setTasks(List<FolderProcessor> tasks) {
        this.tasks = tasks;
    }

    public List<String> getResultList() {
        return resultList;
    }

    public void setResultList(List<String> resultList) {
        this.resultList = resultList;
    }
}