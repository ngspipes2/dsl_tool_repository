package implementations;

import interfaces.IRepository;
import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.RepositoryException;
import utils.Util;

import java.util.Map;

public abstract class Repository implements IRepository {

    protected String location;
    protected Map<String, Object> config;


    public Repository(String location, Map<String, Object> config) {
        this.location = location;
        this.config = config;
    }



    @Override
    public String getLocation() throws RepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws RepositoryException { return this.config; }


}
