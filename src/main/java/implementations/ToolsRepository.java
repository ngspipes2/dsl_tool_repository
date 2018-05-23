package implementations;

import interfaces.IToolsRepository;
import utils.ToolRepositoryException;

import java.util.Map;

public abstract class ToolsRepository implements IToolsRepository {

    protected String location;
    protected Map<String, Object> config;

    public ToolsRepository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }



    @Override
    public String getLocation() throws ToolRepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws ToolRepositoryException { return this.config; }


}
