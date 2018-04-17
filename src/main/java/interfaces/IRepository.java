package interfaces;

import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.RepositoryException;
import java.util.Collection;
import java.util.Map;

public interface IRepository {

    String getLocation() throws RepositoryException;
    Map<String, Object> getConfig() throws RepositoryException;

    Collection<IToolDescriptor> getAll() throws RepositoryException;
    IToolDescriptor get(String id) throws RepositoryException;
    void update(IToolDescriptor entity) throws RepositoryException;
    void insert(IToolDescriptor entity) throws RepositoryException;
    void delete(String id) throws RepositoryException;
}