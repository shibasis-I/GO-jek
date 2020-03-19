package com.ApiComparator;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.get;

/**
 * @author Shibasis
 */
public class CompareApis {
    static BufferedReader b1 = null;
    static BufferedReader b2 = null;

    static List<String> list_file1 = null;
    static List<String> list_file2 = null;

    @Test(priority = 4,dependsOnMethods = {"content1NullValidations","content2NullValidations",
            "response1NullValidations","response2NullValidations"})
    public void responseMatchValidations(){

        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //int count=0;int currline=0;
        for(int i=0;i<list_file1.size();i++){
            //currline++;
            String content1=list_file1.get(i);
            for(int j=0;j<list_file2.size();j++){
                String content2=list_file2.get(j);
                if((content1.equals(content2))&&(i==j)){
                    //count++;
                    Response for1stline = get(content1);
                    Response for2ndline = get(content2);

                    String responseinstring1=for1stline.asString();
                    String responseinstring2=for2ndline.asString();

                    if(responseinstring1.equalsIgnoreCase(responseinstring2)){
                        System.out.println(content1 +" equals "+ content2);
                    }
                }
            }
        }
        /*System.out.println("Total matches found "+ count);
        System.out.println("Size of File1 is "+list_file1.size()+" and Size of File2 is "+ list_file2.size());*/
    }

    @Test(priority = 5, dependsOnMethods = {"content1NullValidations","content2NullValidations",
                                            "response1NullValidations","response2NullValidations"})
    public void responseMismatchValidatins(){
        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //int count=0;int currline=0;
        for(int i=0;i<list_file1.size();i++){
            //currline++;
            String content1=list_file1.get(i);
            for(int j=0;j<list_file2.size();j++){
                String content2=list_file2.get(j);
                if(!(content1.equals(content2))&&(i==j)){
                    System.out.println(content1 +" not equals "+ content2);
                }
            }
        }
    }

    @Test(priority = 0)
    public void content1NullValidations(){
        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<list_file1.size();i++){
            String content1=list_file1.get(i);

            Assert.assertNotNull(content1);
        }
    }

    @Test(priority = 1)
    public void content2NullValidations(){
        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<list_file1.size();i++){
            String content1=list_file1.get(i);
            for(int j=0;j<list_file2.size();j++) {
                String content2 = list_file2.get(j);

                Assert.assertNotNull(content2);
            }
        }
    }

    @Test(priority = 2)
    public void response1NullValidations(){

        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<list_file1.size();i++){

            String content1=list_file1.get(i);
            for(int j=0;j<list_file2.size();j++){
                String content2=list_file2.get(j);
                if((content1.equals(content2))&&(i==j)){

                    Response for1stline = get(content1);

                    String responseinstring1=for1stline.asString();

                    Assert.assertNotNull(responseinstring1);

                }
            }
        }

    }

    @Test(priority = 3)
    public void response2NullValidations(){

        final String file1 = "File1.txt";
        final String file2 = "File2.txt";

        list_file1 = new ArrayList<String>();
        list_file2 = new ArrayList<String>();

        String Text = null;

        try {
            b1 = new BufferedReader(new FileReader(file1));
            while ((Text = b1.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file1.add(Text);
            }
            b2 = new BufferedReader(new FileReader(file2));
            while ((Text = b2.readLine()) != null) {
                Assert.assertNotNull(Text);
                list_file2.add(Text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is missing/incorrect name");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<list_file1.size();i++){
            String content1=list_file1.get(i);
            for(int j=0;j<list_file2.size();j++){
                String content2=list_file2.get(j);
                if((content1.equals(content2))&&(i==j)){

                    Response for2ndline = get(content2);

                    String responseinstring2=for2ndline.asString();

                    Assert.assertNotNull(responseinstring2);

                }
            }
        }

    }

    @BeforeClass
    public void InsertintoFiles(){

        System.out.println("Testvalidations initialized");
        System.out.println("Make sure you have entered content into given files.");

    }
    @AfterMethod
    public void postInputs() throws IOException {
        b1.close();
        b2.close();
    }
}
