package com.bangmaple.lms.authentication.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Define functions for processing the JSON object.
 */
@Slf4j
public final class JsonUtil
{
  private JsonUtil()
  {
  }

  /**
   * Get an string value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @param defaultValue fallback string value to return if none exists
   * @return string value
   */
  public static String getString(JSONObject object, String name, String defaultValue)
  {
    if (object == null || !object.has(name) || object.isNull(name))
    {
      return defaultValue;
    }

    try
    {
      return object.getString(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return defaultValue;
    }
  }

  /**
   * Get a string value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @return string value
   */
  public static String getString(JSONObject object, String name)
  {
    return getString(object, name, null);
  }

  /**
   * Get an integer value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @param defaultValue fallback integer value to return if none exists
   * @return integer value
   */
  public static Integer getInt(JSONObject object, String name, Integer defaultValue)
  {
    if (object == null || !object.has(name))
    {
      return defaultValue;
    }

    try
    {
      return object.getInt(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return defaultValue;
    }
  }

  /**
   * Get an long value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @param defaultValue fallback long value to return if none exists
   * @return long value
   */
  public static Long getLong(JSONObject object, String name, Long defaultValue)
  {
    if (object == null || !object.has(name))
    {
      return defaultValue;
    }

    try
    {
      return object.getLong(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return defaultValue;
    }
  }

  /**
   * Get an long value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @return long value
   */
  public static Long getLong(JSONObject object, String name)
  {
    return getLong(object, name, null);
  }

  /**
   * Get an integer value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @return integer value
   */
  public static Integer getInt(JSONObject object, String name)
  {
    return getInt(object, name, null);
  }

  /**
   * Get a boolean value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @param defaultValue fallback boolean value to return if none exists
   * @return boolean value
   */
  public static Boolean getBoolean(JSONObject object, String name, Boolean defaultValue)
  {
    if (object == null || !object.has(name))
    {
      return defaultValue;
    }

    try
    {
      return object.getBoolean(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return defaultValue;
    }
  }

  /**
   * Get a boolean value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @return boolean value
   */
  public static Boolean getBoolean(JSONObject object, String name)
  {
    return getBoolean(object, name, null);
  }

  /**
   * Get a JSONObject value for a given key from a JSON object.
   * @param object given JSON object
   * @param name a key
   * @return JSON object value
   */
  public static JSONObject getJSONObject(JSONObject object, String name)
  {
    if (object == null || !object.has(name))
    {
      return null;
    }

    try
    {
      return object.getJSONObject(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * Get a JSONArray of values for a given key from a JSON object.
   * @param object a given JSON object
   * @param name a key to look for
   * @return JSON array
   */
  public static JSONArray getJSONArray(JSONObject object, String name)
  {
    if (object == null || !object.has(name))
    {
      return null;
    }

    try
    {
      return object.getJSONArray(name);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * Get a JSONObject value from a JSONArray.
   * @param array given input array
   * @param index index of value
   * @return JSON object
   */
  public static JSONObject getJSONObject(JSONArray array, int index)
  {
    if (array == null || index < 0 || (index >= array.length()))
    {
      return null;
    }

    try
    {
      return array.getJSONObject(index);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * Put a value to a JSON object.
   * @param object a given object
   * @param name key
   * @param value value
   */
  public static void put(JSONObject object, String name, Object value)
  {
    try
    {
      object.put(name, value);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
    }
  }

  /**
   * Convert an object to JSON string.
   * @param obj a given object
   * @return JSON representation of object
   */
  public static String toJsonString(Object obj)
  {
    try {
      GsonBuilder gsonBuilder = new GsonBuilder();
      gsonBuilder.serializeNulls();
      Gson gson = gsonBuilder.create();
      return gson.toJson(obj);
    }
    catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * Convert an object to JSON string not include null attributes
   * @param obj a given object
   * @return JSON representation of object
   */
  public static String toJsonStringWithoutNull(Object obj)
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    return gson.toJson(obj);
  }

  /**
   * Convert an object to JSON string.
   * @param obj a generic object
   * @return JSON string
   * @throws RuntimeException a run time exception
   */
  public static String toJsonStringJackson(Object obj)
  {
    ObjectWriter ow = new ObjectMapper().writer();
    String json;
    try
    {
      json = ow.writeValueAsString(obj);
    }
    catch (JsonProcessingException e)
    {
      log.error(e.getMessage(), e);
      throw new RuntimeException("Json processing error", e);
    }
    return json;
  }

  /**
   * Parse JSON string to List of a given type.
   * @param data string input
   * @param clazz target type
   * @return instantiated list of target type
   */
  public static <T> List<T> toListObjectFromJson(String data, Class<T> clazz) {
    return new Gson().fromJson(data, TypeToken.getParameterized(ArrayList.class, clazz).getType());
  }

  /**
   * Parses JSON string to a given type
   * @param data string input
   * @param clazz target type
   * @return instantiated target type
   */
  public static <T> T toObjectFromJson(String data, Class<T> clazz)
  {
    try
    {
      return new Gson().fromJson(data, TypeToken.getParameterized(clazz).getType());
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * Note: this is not ideal approach to check validity of JSON
   * Determines if passed in JSON string is a valid parsable JSON
   *
   * @param json JSON string
   * @return true or false
   */
  public static boolean isJSONValid(String json) {
    try {
      new JSONObject(json);
    } catch (JSONException ex) {
      // TODO: refactor this. Removing this logging as it is not helpful and is verbose
      //log.error(ex.getMessage(), ex);
      try {
        new JSONArray(json);
      } catch (JSONException ex1) {
        log.warn("Invalid JSON provided");
        return false;
      }
    }
    return true;
  }

  /**
   * Note: this is not ideal approach to check for JSON array
   * Determines if passed in JSON string is a JSON array
   *
   * @param json a valid JSON string
   * @return true or false
   */
  public static boolean isJSONArray(String json) {
    try {
      new JSONArray(json);
    } catch (JSONException ex1) {
      // TODO: refactor this. Removing this logging as it is not helpful and is verbose
      log.warn("Invalid JSON Array provided");
      return false;
    }
    return true;
  }

  public static List<String> getJSONArrayStringValues(JSONObject object, String name)
  {
    try {
      List<String> values = new ArrayList<>();
      JSONArray arrayData = getJSONArray(object, name);
      if (arrayData != null) {
        int length = arrayData.length();
        for (int i = 0; i < length; i++) {
          values.add(arrayData.get(i).toString());
        }
        return values;
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return new ArrayList<>();
  }

  /**
   * Parse a json string to JSONObject
   * @param json
   * @return JSONObject
   */
  public static JSONObject toJSONObject(String json)
  {
    try
    {
      return new JSONObject(json);
    }
    catch (JSONException ex)
    {
      log.warn("Invalid JSON provided");
      return null;
    }
  }

  /**
   * Parse a json string to JSONArray
   * @param json
   * @return JSONObject
   */
  public static JSONArray toJSONArray(String json)
  {
    try
    {
      return new JSONArray(json);
    }
    catch (JSONException ex)
    {
      log.warn("Invalid JSON provided");
      return null;
    }
  }

  /**
   * Sort json array
   * @param jsonArray
   * @param sortKeyPath e.g: "participant,updateOn" => updateOn is the participant's attribute which wants to sort
   * @return JSONArray
   */
  public static JSONArray sortJSONArray(JSONArray jsonArray, String sortKeyPath) {
    if (Objects.isNull(jsonArray) || StringUtility.isEmpty(sortKeyPath)) {
      return new JSONArray();
    }
    List<JSONObject> jsonValues = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      try {
        jsonValues.add(jsonArray.getJSONObject(i));
      }
      catch (JSONException e) {
        log.warn(e.getMessage());
      }
    }
    jsonValues.sort(Comparator.comparing(item -> {
      String[] sortKeys = sortKeyPath.split(StringUtility.COMMA);
      if (sortKeys.length == 1) {
        return JsonUtil.getString(item, sortKeys[0]);
      }
      JSONObject parentObj = null;
      for (int i = 0; i < sortKeys.length - 1; i++) {
        if (Objects.isNull(parentObj)) {
          parentObj = getJSONObject(item, sortKeys[i]);
          continue;
        }
        parentObj = getJSONObject(parentObj, sortKeys[i]);
      }
      return JsonUtil.getString(parentObj, sortKeys[sortKeys.length - 1]);
    }, Comparator.nullsFirst(Comparator.naturalOrder())));

    JSONArray sortedJsonArray = new JSONArray();
    jsonValues.forEach(sortedJsonArray::put);
    return sortedJsonArray;
  }
}
