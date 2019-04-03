package com.liusir.thread.basic.book.pipeinputoutput;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream outputStream){

        try {
            System.out.println("write");
            for (int i = 0; i < 100; i++) {

                String outData = String.valueOf(i + 1);
                outputStream.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
