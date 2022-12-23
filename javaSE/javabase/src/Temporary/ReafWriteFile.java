package Temporary;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReafWriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\A\\B\\C\\abc.txt");
        FileReader fr = new FileReader(file);
//        System.out.println(fr.read());
        BufferedReader bfr = new BufferedReader(fr);
//        System.out.println(bfr.readLine());
        Map map = new HashMap<String,Integer>();
        while (true){
            String temp = bfr.readLine();
            if (temp != null){
                String[] s = temp.split("\t");
                map.put(s[0],s[1]);
                continue;
            }
            break;
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(map.get(it.next()));
        }

        FileWriter ft = new FileWriter(file);
        BufferedWriter bft = new BufferedWriter(ft);
        bft.write("d\t135\nc\t246");
        bft.flush();
        bft.close();
    }

}
