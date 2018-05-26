package pt.isel.ngspipes.tool_repository.implementations;

import pt.isel.ngspipes.tool_repository.interfaces.IToolsRepository;
import utils.ToolsRepositoryException;

import java.util.Map;

public abstract class ToolsRepository implements IToolsRepository {

    protected String location;
    protected Map<String, Object> config;

    public ToolsRepository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }



    @Override
    public String getLocation() throws ToolsRepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws ToolsRepositoryException { return this.config; }


}
