package org.om.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.om.Model.Temp1;
import org.om.Model.Temp2;
import org.om.Service.Table1DataSave;
import org.om.Service.Table2DataSave;
import org.om.config.PostgresConnection;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Table2SaveData {

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
    public void saveData(String token) {
        Logger logger = Logger.getLogger(Table2SaveData.class.getName());


        logger.info("Inside getcuraData()");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String file = "JSON/CURA.json";

        try {
            String json = readFileAsString(file);
            logger.info(json);
            JsonNode node = mapper.readTree(json);
            Temp2[]  temp2 = mapper.readValue(node.get("Body").get("IXRes").get("Data").get(1).toString(),Temp2[].class);
            logger.info("Temp1 : "+ temp2);

            logger.info("Node : "+node.get("Body").get("IXRes").get("Data").get(0));
            Table2DataSave table2DataSave= new Table2DataSave();
            table2DataSave.dataStore(Arrays.asList(temp2));
        } catch (Exception e){
            logger.info("Unable to save users: " + e.getMessage());
        }


    }
}
