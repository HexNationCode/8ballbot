package com.spoopy.classes;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {
    public static ArrayList<String> returnResponses(File f) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(f));

        ArrayList<String> responses = new ArrayList<>();

        while (reader.ready())
            responses.add(reader.readLine());

        return responses;
    }
}
