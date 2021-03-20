package ru.stqa.pft.addressbook.generators;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.File;
import java.lang.reflect.Type;

public class FileSerializer implements JsonSerializer<File> {

  @Override
  public JsonElement serialize(File photo, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(photo.getPath());
  }
}
