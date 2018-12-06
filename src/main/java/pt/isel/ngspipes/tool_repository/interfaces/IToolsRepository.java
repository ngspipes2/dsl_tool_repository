package pt.isel.ngspipes.tool_repository.interfaces;

import pt.isel.ngspipes.tool_descriptor.interfaces.IToolDescriptor;
import utils.ToolsRepositoryException;

import java.util.Collection;
import java.util.Map;

public interface IToolsRepository {

    String getLocation() throws ToolsRepositoryException;
    Map<String, Object> getConfig() throws ToolsRepositoryException;

    byte[] getLogo() throws ToolsRepositoryException;
    void setLogo(byte[] logo) throws ToolsRepositoryException;

    Collection<String> getToolsNames() throws ToolsRepositoryException;

    Collection<IToolDescriptor> getAll() throws ToolsRepositoryException;
    IToolDescriptor get(String toolName) throws ToolsRepositoryException;
    void update(IToolDescriptor tool) throws ToolsRepositoryException;
    void insert(IToolDescriptor tool) throws ToolsRepositoryException;
    void delete(String toolName) throws ToolsRepositoryException;
}