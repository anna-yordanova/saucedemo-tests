package util;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer
{
    @Override
    public Locale locale()
    {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry)
    {
        JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
        typeRegistry.setDefaultParameterTransformer(jacksonTableTransformer);
    }

    private static final class JacksonTableTransformer
            implements ParameterByTypeTransformer, TableEntryByTypeTransformer, TableCellByTypeTransformer
    {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Object transform(String string, Type type)
        {
            return objectMapper.convertValue(string, objectMapper.constructType(type));
        }

        @Override
        public <T> T transform(Map<String, String> map, Class<T> aClass,
                TableCellByTypeTransformer tableCellByTypeTransformer)
        {
            return objectMapper.convertValue(map, aClass);
        }

        @Override
        public <T> T transform(String s, Class<T> aClass)
        {
            return objectMapper.convertValue(s, aClass);
        }
    }
}
