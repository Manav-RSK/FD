package com.example.facedetection;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MyModelInference {

    // Load the TensorFlow Lite model
    private Interpreter tflite = new Interpreter(loadModelFile());

    public MyModelInference() {
    }

    private MappedByteBuffer loadModelFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\DELL\\Downloads\\mobilenet_v1_1.0_224_quant_and_labels\\mobilenet_v1_1.0_224_quant.tflite");
            FileChannel fileChannel = fileInputStream.getChannel();
            long startOffset = 0;
            long declaredLength = fileChannel.size();
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

