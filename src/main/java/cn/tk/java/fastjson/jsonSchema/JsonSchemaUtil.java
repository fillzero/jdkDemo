package cn.tk.java.fastjson.jsonSchema;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

@Slf4j
public class JsonSchemaUtil
{
	public String validate(String jsonSchema,String reqJsonString)
	{
		String retString = "";
		try
        {
			ObjectMapper oMapper  = new ObjectMapper();
			final JsonNode fstabSchema = oMapper.readTree(jsonSchema);
			final JsonNode reqSchema = oMapper.readTree(reqJsonString);
			
			final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
	        final com.github.fge.jsonschema.main.JsonSchema schema = factory.getJsonSchema(fstabSchema);
	        ProcessingReport report = schema.validate(reqSchema);
	        if(report.isSuccess())
	        {
	        	retString = "ok";
	        }
	        else
	        {
	        	retString = report.toString();
	        	log.debug("JsonSchemaUtil validate fail {}" , retString);
	        }
        }
        catch (Exception e)
        {
	        retString = "SYSTEM_ILLEGAL_REQUEST";
	        log.debug("JsonSchemaUtil validate Exception {}" , e.toString());
	        e.printStackTrace();
        }
        
        return retString;
	}
	
	public String validate(String jsonSchema,HashMap<String, String> map)
	{
		String retString = "";
		try
        {
			ObjectMapper oMapper  = new ObjectMapper();
			final JsonNode fstabSchema = oMapper.readTree(jsonSchema);
			final JsonNode reqSchema = oMapper.readTree(JSONObject.toJSONString(map));
			
			final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
	        final com.github.fge.jsonschema.main.JsonSchema schema = factory.getJsonSchema(fstabSchema);
	        ProcessingReport report = schema.validate(reqSchema);
	        if(report.isSuccess())
	        {
	        	retString = "ok";
	        }
	        else
	        {
	        	retString = report.toString();
	        }
        }
        catch (Exception e)
        {
	        retString = "SYSTEM_ILLEGAL_REQUEST";
        }
        
        return retString;
	}
}
