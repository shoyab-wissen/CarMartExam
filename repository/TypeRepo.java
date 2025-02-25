package Test.repository;

import java.util.List;

import Test.models.Type;

public interface TypeRepo {

    public List<Type> getAllTypes();

    public Boolean addType(Type type);
}
