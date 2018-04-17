package implementations;

import pt.isel.ngspipes.tool_descriptor.interfaces.tool.IToolDescriptor;
import utils.IO;
import utils.RepositoryException;

import java.io.IOException;
import java.util.Collection;

public class LocalRepository extends Repository {

    public LocalRepository() { super("LocalWindows"); }

    @Override
    protected void innerLoad(SupportedRepository supportedRepository) {
        this.accessLocation = location;
    }

    @Override
    protected boolean evaluateConnection() {
        try {
            IO.read(location + "/" + TOOLS_NAMES_FILE);
            return true;
        } catch (IOException e) {
            throw new RepositoryException("Not supported to connect to location:" + location, e);
        }
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
