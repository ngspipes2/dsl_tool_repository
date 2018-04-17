package implementations;

import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.Http;
import utils.RepositoryException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

public class GithubRepository extends Repository {

    public GithubRepository() { super("Github"); }

    @Override
    public Collection<IToolDescriptor> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public IToolDescriptor get(String id) throws RepositoryException {
        String descriptorUri = this.accessLocation + "/" + id + "/Descriptor.json";
        return null;
    }

    @Override
    public void update(IToolDescriptor entity) throws RepositoryException {

    }

    @Override
    public void insert(IToolDescriptor entity) throws RepositoryException {

    }

    @Override
    public void delete(String id) throws RepositoryException {

    }

    @Override
    protected void innerLoad(SupportedRepository supportedRepository) {
        if(supportedRepository.access_location != null && !supportedRepository.access_location.isEmpty()) {
            this.accessLocation = location.replace(supportedRepository.base_location, supportedRepository.access_location);
        }
        accessLocation = accessLocation + "/master";
    }

    @Override
    protected boolean evaluateConnection() {
        return Http.canConnect(accessLocation + "/" + TOOLS_NAMES_FILE);
    }

    @Override
    public String loadToolLogo(String toolName) throws RepositoryException {
        StringBuilder logoLocation = new StringBuilder(this.accessLocation);
        logoLocation.append("/")
                    .append(toolName)
                    .append("/")
                    .append(LOGO_FILE_NAME);
        return existsLogo(logoLocation.toString())? logoLocation.toString() : null;
    }

    private boolean existsLogo(String location) throws RepositoryException {
        try{
            URL url = new URL(location);
            HttpURLConnection huc =  (HttpURLConnection)  url.openConnection();
            huc.setRequestMethod("HEAD");

            return huc.getResponseCode() == HttpURLConnection.HTTP_OK;
        }catch(IOException e){
            throw new RepositoryException("Error checking tool logo", e);
        }
    }
}
