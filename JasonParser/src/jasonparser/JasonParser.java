/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasonparser;

import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Hsin
 */
public class JasonParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "F:/中興資管所研究生/DataSet/QALD/QALD-6/qald-6-train-hybrid.json";
        //String fileName = "F:/中興資管所研究生/DataSet/QALD/QALD-6/qald-6-test-hybrid.json";
        //String fileName = "F:/中興資管所研究生/DataSet/QALD/QALD-6/qald-6-train-datacube.json";
        //String fileName = "F:/中興資管所研究生/DataSet/QALD/QALD-6/qald-6-test-datacube.json";
        System.out.println("尋找檔案"+fileName+"...");
        File jsonFile = new File(fileName);
        if (jsonFile.exists()) {
            System.out.println("找到檔案"+jsonFile.toString());
            fileReader fr = new fileReader(fileName);
            JSONObject j = new JSONObject(fr.getContent());
            JSONArray jArr = j.getJSONArray("questions");
            
            System.out.println("檔案內容:");
            System.out.println(fr.getContent());
            System.out.println("--------------------------------------------------------------------");
            System.out.println("資料集:");
            System.out.println(j.getJSONObject("dataset"));
            System.out.println("--------------------------------------------------------------------");
            System.out.println("共"+jArr.length());
            for(int i = 0 ; i < jArr.length(); i++){
                JSONObject oj = jArr.getJSONObject(i);
                System.out.println(oj.get("id"));
                System.out.println(oj.getJSONArray("question"));
                System.out.println(oj.getJSONObject("query"));
                System.out.println(oj.getJSONArray("answers"));
            }
            
            System.out.println("--------------------------------------------------------------------");
           
            
        }else{
            System.out.println("No such file.");
        }
    }
    
}
