package implementations;

import interfaces.IToolRepository;
import utils.RepositoryException;

import java.util.Map;

public abstract class ToolRepository implements IToolRepository {

    protected String location;
    protected Map<String, Object> config;


    public ToolRepository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }



    @Override
    public String getLocation() throws RepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws RepositoryException { return this.config; }


}
