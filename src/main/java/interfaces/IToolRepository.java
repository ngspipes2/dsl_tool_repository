package interfaces;

import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.ToolRepositoryException;
import java.util.Collection;
import java.util.Map;

public interface IToolRepository {

    String getLocation() throws ToolRepositoryException;
    Map<String, Object> getConfig() throws ToolRepositoryException;

    Collection<IToolDescriptor> getAll() throws ToolRepositoryException;
    IToolDescriptor get(String id) throws ToolRepositoryException;
    void update(IToolDescriptor entity) throws ToolRepositoryException;
    void insert(IToolDescriptor entity) throws ToolRepositoryException;
    void delete(String id) throws ToolRepositoryException;
}