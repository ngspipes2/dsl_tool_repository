package implementations;

import interfaces.IRepository;
import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.RepositoryException;
import utils.Util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public abstract class Repository implements IRepository {

    protected static final String LOGO_FILE_NAME = "Logo.png";
    protected static final String TOOLS_NAMES_KEY = "toolsName";
    protected static final String CONFIGURATORS_NAMES_KEY = "configuratorsFileName";
    protected static final String TOOLS_NAMES_FILE = "Tools.json";
    protected static final String CONFIGURATORS_NAMES_FILE = "Configurators.json";
    protected static final String DESCRIPTOR_FILE_NAME  = "Descriptor";


    protected String location;
    protected Map<String, Object> configs;
    protected String accessLocation;
    private final String label;


    public Repository(String label) { this.label = label; }

    @Override
    public String getLocation() throws RepositoryException { return this.location; }

    @Override
    public Map<String, Object> getConfig() throws RepositoryException { return this.configs; }

    @Override
    public boolean load(String location, Map<String, Object> config) throws RepositoryException {
        try {
            boolean supportedRepo;
            SupportedRepository supportedRepository = Util.getRepositoriesSupportedData(label);
            supportedRepo = evaluateLocation(supportedRepository, location);
                if(supportedRepo) {
                    setFields(location, config, supportedRepository);
                    innerLoad(supportedRepository);
                    return evaluateConnection();
                }
        } catch (RepositoryException e) {
            throw new RepositoryException("Error loading repository", e);
        }
        return false;
    }

    @Override
    public IToolDescriptor get(String id) throws RepositoryException {
        return null;
    }

    protected abstract void innerLoad(SupportedRepository supportedRepository);
    protected abstract String loadToolLogo(String toolName) throws RepositoryException;
    protected abstract boolean evaluateConnection();


    protected void setFields(String location, Map<String, Object> config, SupportedRepository supportedRepo) {

        this.location = location;
        this.configs = config;
    }


    private boolean evaluateLocation(SupportedRepository supportedRepo, String location) {
        boolean contains = location.contains(supportedRepo.base_location);
        boolean regexMatch = location.matches(supportedRepo.base_location);

        return contains ^ regexMatch;
    }
}
