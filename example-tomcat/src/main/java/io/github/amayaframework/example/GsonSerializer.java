package io.github.amayaframework.example;

import com.google.gson.Gson;
import io.github.amayaframework.http.ContentType;
import io.github.amayaframework.serializer.Serializer;
import io.github.amayaframework.serializer.TypedSerializer;

@TypedSerializer(ContentType.JSON)
public class GsonSerializer implements Serializer {
    private static final Gson GSON = new Gson();

    @Override
    public <T> T deserialize(String source, Class<T> clazz) {
        return GSON.fromJson(source, clazz);
    }

    @Override
    public String serialize(Object source) {
        return GSON.toJson(source);
    }
}
