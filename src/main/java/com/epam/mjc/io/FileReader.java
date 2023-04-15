package com.epam.mjc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FileReader {

    public Profile getDataFromFile(File file) {
            List<String> profiles = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            int i = 0;
            while ((row = Objects.requireNonNull(bufferedReader).readLine()) != null){
                String[] s = row.split(" ");
//                Profile profile = new Profile(s[0],Integer.parseInt(s[1]),s[2],Long.parseLong(s[3]));
//                profiles.add(profile);

                profiles.add(i,s[1]);
                i++;
            }
            bufferedReader.close();
            System.out.println(profiles);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }


        return new Profile(profiles.get(0),Integer.parseInt(profiles.get(1)),profiles.get(2),Long.parseLong(profiles.get(3)));
    }
}
