package pt.isel.ngspipes.tool_repository.implementations;

import pt.isel.ngspipes.tool_repository.interfaces.IToolsRepository;
import utils.ToolRepositoryException;

import java.util.Map;

public abstract class ToolsRepository implements IToolsRepository {

    protected String location;
    protected Map<String, Object> config;
    protected String type;

    public ToolsRepository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }


    public ToolsRepository(String location, Map<String, Object> config, String type) {
        this.location = location;
        this.config = config;
        this.type = type;
    }


    @Override
    public String getLocation() throws ToolRepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws ToolRepositoryException { return this.config; }


}
