package implementations;

import interfaces.IToolRepository;
import utils.ToolRepositoryException;

import java.util.Map;

public abstract class ToolRepository implements IToolRepository {

    protected String location;
    protected Map<String, Object> config;


    public ToolRepository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }



    @Override
    public String getLocation() throws ToolRepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws ToolRepositoryException { return this.config; }


}
