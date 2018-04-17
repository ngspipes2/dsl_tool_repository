package implementations;

import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.Http;
import utils.RepositoryException;

import java.util.Collection;

public class UriBasedRepository extends Repository {

    public UriBasedRepository() { super("UriBased"); }

    @Override
    protected void innerLoad(SupportedRepository supportedRepository) {
        this.accessLocation = location;
    }

    @Override
    protected boolean evaluateConnection() {
        return Http.canConnect(location);
    }

    @Override
    protected String loadToolLogo(String toolName) throws RepositoryException {
        return null;
    }

    @Override
    public Collection<IToolDescriptor> getAll() throws RepositoryException {
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
}
