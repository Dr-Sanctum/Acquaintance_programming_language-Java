package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * В файле содержится строка с исходными данными в такой форме: 
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
 * Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. 
 * Значения null не включаются в запрос.
 *
 */
public class App 
{
    /**
     * Для выполнения задания была применена сторонняя библиотека Gson для разбора строк формата Json,
     * StringBuilder для формирования новых строк
     */
    public static void main( String[] args )
    {
    String pathProject = System.getProperty("user.dir");
    String pathFile = pathProject.concat("/file.txt");
    File f3 = new File(pathFile);
    try(BufferedReader reader = new BufferedReader(new FileReader(f3)))
        {
            String text = reader.readLine();
            JsonObject jsonObject = JsonParser.parseString(text).getAsJsonObject();
            Set textJson = jsonObject.entrySet();
            Iterator jsonIterator = textJson.iterator();
            Set keyJson = jsonObject.asMap().keySet();
            Iterator keyJsonIterator = keyJson.iterator();
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT * FROM students WHERE ");

            while(jsonIterator.hasNext()) 
            {
                boolean flag = jsonObject.get(keyJsonIterator.next().toString()).getAsString().equals("null");
                if (!flag) 
                {
                    builder.append(jsonIterator.next());
                    builder.append(" AND ");
                }
                else
                {
                jsonIterator.next();
                }
            }
            builder.delete(builder.length()-5, builder.length());
            System.out.println(builder.toString());
        }
        
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }   
}
