package com.liusir.thread.basic.mul;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("input base directory");
        String directory = in.nextLine();
        System.out.print("key word:");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
        new Thread(new FileEnumerationTask(queue, new File(directory))).start();
        for (int i=0; i< SEARCH_THREADS; i++){
            new Thread(new SearchTask(queue, keyword)).start();
        }


    }
}
class FileEnumerationTask implements Runnable{

    public static File DUMMY = new File("");
    private BlockingQueue<File> blockingQueue;
    private File start;

    public FileEnumerationTask(BlockingQueue queue, File start){

        this.blockingQueue = queue;
        this.start = start;

    }

    public void enumerate(File directory){

        File[] files = directory.listFiles();
        for (File file: files){
            if(file.isDirectory()){
                enumerate(file);
            }else {
                blockingQueue.add(file);
            }
        }

    }

    @Override
    public void run() {

        enumerate(start);
        blockingQueue.add(DUMMY);
    }
}

class SearchTask implements Runnable{

    private BlockingQueue<File> blockingQueue;
    private String keyword;

    public SearchTask(BlockingQueue queue, String keyword){

        this.blockingQueue = queue;
        this.keyword = keyword;

    }

    public void search(File file) throws IOException {

        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine()){
            lineNumber++;
            String line = in.nextLine();
            if(line.contains(keyword)){
                System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
        in.close();

    }


    @Override
    public void run() {

        try {
            boolean done = false;
            while (!done){
                File file = blockingQueue.take();
                if(file == FileEnumerationTask.DUMMY){
                    blockingQueue.put(file);
                    done = true;
                }else {
                    search(file);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (IOException e){

        }
    }
}
