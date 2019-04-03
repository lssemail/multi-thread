package com.liusir.thread.basic.book.pipeinputoutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test {

    public static void main(String[] args) {

        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream();

            outputStream.connect(inputStream);

            ReadThread readThread = new ReadThread(readData, inputStream);
            readThread.start();
            Thread.sleep(2000);

            WriteThread writeThread = new WriteThread(writeData, outputStream);
            writeThread.start();


        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e){

        }


    }
}
